package mx.globant.challenge.view.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.fragment_work_history.*
import kotlinx.android.synthetic.main.layout_connection_error.*
import mx.globant.challenge.R
import mx.globant.challenge.presenter.WorkHistoryPresenter
import mx.globant.challenge.view.adapter.WorkHistoryAdapter
import mx.globant.challenge.view.contract.ListingView
import mx.globant.challenge.view.gone
import mx.globant.challenge.view.visible
import javax.inject.Inject


class WorkHistoryFragment : BaseFragment(), ListingView {

    @Inject
    lateinit var presenter: WorkHistoryPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.initView(this)
        presenter.getWorkHistory()
        retry.setOnClickListener { presenter.getWorkHistory() }
    }

    override fun setupInjection() =
        appComponent.inject(this)

    override fun getLayout(): Int =
        R.layout.fragment_work_history

    override fun showProgressBar() {
        progressBar.visible()
    }

    override fun hideProgressBar() {
        progressBar.gone()
    }

    override fun setupAdapter() {
        workHistoryRecycler.adapter =
            WorkHistoryAdapter(presenter.getCurrentWorkHistory(), activity)
        workHistoryRecycler.layoutManager = LinearLayoutManager(activity)
    }

    override fun showContent() {
        workHistoryRecycler.visible()
    }

    override fun showConnectionError() {
        connectionErrorContainer.visible()
    }

    override fun hideConnectionError() {
        connectionErrorContainer.gone()
    }
}