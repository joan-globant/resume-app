package mx.globant.challenge.presenter

import mx.globant.data.network.BaseCallback
import mx.globant.domain.model.WorkExperience
import mx.globant.challenge.view.contract.ListingView
import mx.globant.domain.usecases.GetWorkHistoryUseCase
import javax.inject.Inject


class WorkHistoryPresenter @Inject constructor(
    private val useCase : GetWorkHistoryUseCase
) : BasePresenter<ListingView>() {

    private lateinit var currentWorkHistory: List<WorkExperience>

    fun getWorkHistory() {
        view?.showProgressBar()
        view?.hideConnectionError()
        useCase.execute(object: BaseCallback<List<WorkExperience>> {
            override fun onSuccess(model: List<WorkExperience>) {
                currentWorkHistory = model
                view?.hideProgressBar()
                view?.showContent()
                view?.setupAdapter()
            }

            override fun onError() {
                view?.hideProgressBar()
                view?.showConnectionError()
            }
        })
    }

    fun getCurrentWorkHistory(): List<WorkExperience> =
        currentWorkHistory
}