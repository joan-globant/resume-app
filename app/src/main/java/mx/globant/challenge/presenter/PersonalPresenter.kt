package mx.globant.challenge.presenter

import mx.globant.challenge.view.contract.PersonalView
import mx.globant.data.network.BaseCallback
import mx.globant.domain.model.PersonalInformation
import mx.globant.domain.usecases.GetPersonalUseCase
import javax.inject.Inject


class PersonalPresenter @Inject constructor(
    private val useCase: GetPersonalUseCase
) : BasePresenter<PersonalView>() {

    fun getPersonalInformation() {
        view?.showProgressBar()
        view?.hideConnectionError()
        useCase.execute(object: BaseCallback<PersonalInformation> {
            override fun onSuccess(model: PersonalInformation) {
                view?.hideProgressBar()
                view?.showContent()
                render(model)
            }

            override fun onError() {
                view?.hideProgressBar()
                view?.showConnectionError()
            }
        })
    }

    private fun render(model: PersonalInformation) {
        view?.apply {
            setAge(model.age)
            setEmail(model.email)
            setPhone(model.telephone)
            setName(model.getFullName())
            setObjective(model.objective)
            setAddress(model.getFullAddress())
        }
    }
}