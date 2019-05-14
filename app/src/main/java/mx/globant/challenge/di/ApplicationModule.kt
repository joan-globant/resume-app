package mx.globant.challenge.di

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import mx.globant.challenge.BuildConfig
import mx.globant.challenge.ResumeApplication
import mx.globant.data.network.ResumeApi
import mx.globant.domain.repository.ResumeRemoteRepository
import mx.globant.domain.repository.ResumeRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class ApplicationModule(private val application: ResumeApplication) {

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder().create()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BuildConfig.SERVER_URL)
            .client(OkHttpClient.Builder().build())
            .build()

    @Provides
    @Singleton
    fun provideResumeApi(retrofit: Retrofit): ResumeApi =
        retrofit.create<ResumeApi>(ResumeApi::class.java)

    @Provides
    fun providesNetworkManager(): NetworkInfo? =
        (application.applicationContext.
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).
            activeNetworkInfo

    @Provides
    fun providesResumeRepository(resumeApi: ResumeApi, networkManager: NetworkInfo?, gson: Gson): ResumeRepository =
        ResumeRemoteRepository(resumeApi, networkManager, gson)
}