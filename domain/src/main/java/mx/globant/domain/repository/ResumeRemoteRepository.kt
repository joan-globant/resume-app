package mx.globant.domain.repository

import android.net.NetworkInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import mx.globant.data.entities.GistEntity
import mx.globant.data.network.BaseCallback
import mx.globant.data.network.RequestHandler
import mx.globant.data.network.ResumeApi
import mx.globant.domain.model.PersonalInformation
import mx.globant.domain.model.Skill
import mx.globant.domain.model.WorkExperience
import javax.inject.Inject


class ResumeRemoteRepository @Inject constructor(
    private val resumeApi: ResumeApi, private val networkManager: NetworkInfo?, private val gson: Gson
) : ResumeRepository {

    override fun getSkills(callback: BaseCallback<List<Skill>>) {
        RequestHandler<GistEntity, List<Skill>>(networkManager)
            .request(resumeApi.getSkills(), callback) {
                gson.fromJson(it.files.rootFile.content, object : TypeToken<List<Skill>>() {}.type)
            }
    }

    override fun getWorkHistory(callback: BaseCallback<List<WorkExperience>>) {
        RequestHandler<GistEntity, List<WorkExperience>>(networkManager)
            .request(resumeApi.getWorkExperience(), callback) {
                gson.fromJson(it.files.rootFile.content, object : TypeToken<List<WorkExperience>>() {}.type)
            }
    }

    override fun getPersonalInformation(callback: BaseCallback<PersonalInformation>) {
        RequestHandler<GistEntity, PersonalInformation>(networkManager)
            .request(resumeApi.getPersonalInformation(), callback) {
                gson.fromJson(it.files.rootFile.content, PersonalInformation::class.java)
            }
    }
}