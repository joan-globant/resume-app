package mx.globant.challenge.presenter

import mx.globant.challenge.view.contract.ListingView
import mx.globant.data.network.BaseCallback
import mx.globant.domain.model.Skill
import mx.globant.domain.usecases.GetSkillsUseCase
import javax.inject.Inject


class SkillsPresenter @Inject constructor(
    private val useCase: GetSkillsUseCase
) : BasePresenter<ListingView>() {

    private lateinit var currentSkills: List<Skill>

    fun getSkills() {
        view?.showProgressBar()
        view?.hideConnectionError()
        useCase.execute(object: BaseCallback<List<Skill>> {
            override fun onSuccess(model: List<Skill>) {
                currentSkills = model
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

    fun getCurrentSkills(): List<Skill> =
        currentSkills
}