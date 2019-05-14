package mx.globant.domain.usecases

import mx.globant.data.network.BaseCallback
import mx.globant.domain.model.Skill
import mx.globant.domain.repository.ResumeRepository
import javax.inject.Inject


class GetSkillsUseCase @Inject constructor(
    private val repository: ResumeRepository
) : UseCase<List<Skill>> {

    override fun execute(callback: BaseCallback<List<Skill>>) {
        repository.getSkills(callback)
    }
}