package mx.globant.challenge.view.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.fragment_skills.*
import kotlinx.android.synthetic.main.layout_connection_error.*
import mx.globant.challenge.R
import mx.globant.challenge.presenter.SkillsPresenter
import mx.globant.challenge.view.adapter.SkillAdapter
import mx.globant.challenge.view.contract.ListingView
import mx.globant.challenge.view.gone
import mx.globant.challenge.view.visible
import javax.inject.Inject


class SkillsFragment : BaseFragment(), ListingView {

    @Inject
    lateinit var presenter: SkillsPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.initView(this)
        presenter.getSkills()
        retry.setOnClickListener { presenter.getSkills() }
    }

    override fun setupInjection() {
        appComponent.inject(this)
    }

    override fun getLayout(): Int =
        R.layout.fragment_skills

    override fun showProgressBar() {
        progressBar.visible()
    }

    override fun hideProgressBar() {
        progressBar.gone()
    }

    override fun setupAdapter() {
        skillsRecycler.adapter = SkillAdapter(presenter.getCurrentSkills(), activity)
        skillsRecycler.layoutManager = LinearLayoutManager(activity)
    }

    override fun showContent() {
        skillsRecycler.visible()
    }

    override fun showConnectionError() {
        connectionErrorContainer.visible()
    }

    override fun hideConnectionError() {
        connectionErrorContainer.gone()
    }
}