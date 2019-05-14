package mx.globant.domain.usecases

import mx.globant.data.network.BaseCallback
import mx.globant.domain.model.PersonalInformation
import mx.globant.domain.repository.ResumeRepository
import javax.inject.Inject


class GetPersonalUseCase @Inject constructor(
    private val repository: ResumeRepository
) : UseCase<PersonalInformation> {

    override fun execute(callback: BaseCallback<PersonalInformation>) {
        repository.getPersonalInformation(callback)
    }
}