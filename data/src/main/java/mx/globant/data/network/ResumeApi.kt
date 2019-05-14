package mx.globant.data.network

import mx.globant.data.entities.GistEntity
import retrofit2.Call
import retrofit2.http.GET


interface ResumeApi {

    companion object {
        private const val RESUME_PERSONAL = "gists/b97598f0b76e5eb152378f494d7046c7"
        private const val RESUME_SKILLS = "gists/2e90edd56515b9929fb88d08302c7077"
        private const val RESUME_WORKS = "gists/e824c83e8b46ad914bab25b89128d6ef"
    }

    @GET(RESUME_PERSONAL)
    fun getPersonalInformation(): Call<GistEntity>

    @GET(RESUME_SKILLS)
    fun getSkills(): Call<GistEntity>

    @GET(RESUME_WORKS)
    fun getWorkExperience(): Call<GistEntity>
}