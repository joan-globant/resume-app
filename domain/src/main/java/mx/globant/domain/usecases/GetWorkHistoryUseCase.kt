package mx.globant.domain.usecases

import mx.globant.data.network.BaseCallback
import mx.globant.domain.model.WorkExperience
import mx.globant.domain.repository.ResumeRepository
import javax.inject.Inject


class GetWorkHistoryUseCase @Inject constructor(
    private val repository: ResumeRepository
) : UseCase<List<WorkExperience>> {

    override fun execute(callback: BaseCallback<List<WorkExperience>>) {
        repository.getWorkHistory(callback)
    }
}