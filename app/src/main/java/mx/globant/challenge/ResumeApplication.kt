package mx.globant.challenge

import android.app.Application
import mx.globant.challenge.di.ApplicationComponent
import mx.globant.challenge.di.ApplicationModule
import mx.globant.challenge.di.DaggerApplicationComponent


class ResumeApplication: Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
        .build()
    }
}