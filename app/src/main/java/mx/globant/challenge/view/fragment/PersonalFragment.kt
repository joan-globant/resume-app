package mx.globant.challenge.view.fragment

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_personal.*
import kotlinx.android.synthetic.main.layout_connection_error.*
import mx.globant.challenge.R
import mx.globant.challenge.presenter.PersonalPresenter
import mx.globant.challenge.view.contract.PersonalView
import mx.globant.challenge.view.gone
import mx.globant.challenge.view.visible
import javax.inject.Inject


class PersonalFragment : BaseFragment(),
    PersonalView {

    @Inject
    lateinit var presenter: PersonalPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.initView(this)
        presenter.getPersonalInformation()
        retry.setOnClickListener { presenter.getPersonalInformation() }
    }

    override fun setupInjection() =
        appComponent.inject(this)

    override fun getLayout(): Int =
        R.layout.fragment_personal

    override fun showProgressBar() {
        progressBar.visible()
    }

    override fun hideProgressBar() {
        progressBar.gone()
    }

    override fun showContent() {
        contentContainer.visible()
    }

    override fun setName(name: String) {
        nameText.text = name
    }

    override fun setAge(age: String) {
        ageText.text = age
    }

    override fun setEmail(email: String) {
        emailText.text = email
    }

    override fun setPhone(telephone: String) {
        phoneText.text = telephone
    }

    override fun setAddress(fullAddress: String) {
        addressText.text = fullAddress
    }

    override fun setObjective(objective: String) {
        objectiveText.text = objective
    }

    override fun showConnectionError() {
        connectionErrorContainer.visible()
    }

    override fun hideConnectionError() {
        connectionErrorContainer.gone()
    }
}