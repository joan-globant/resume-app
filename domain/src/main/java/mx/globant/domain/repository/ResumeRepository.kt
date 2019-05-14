package mx.globant.domain.repository

import mx.globant.data.network.BaseCallback
import mx.globant.domain.model.PersonalInformation
import mx.globant.domain.model.Skill
import mx.globant.domain.model.WorkExperience


interface ResumeRepository {

    fun getSkills(callback: BaseCallback<List<Skill>>)

    fun getWorkHistory(callback: BaseCallback<List<WorkExperience>>)

    fun getPersonalInformation(callback: BaseCallback<PersonalInformation>)
}