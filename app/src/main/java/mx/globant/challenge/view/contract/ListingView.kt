package mx.globant.challenge.view.contract

interface ListingView : LoadingView,
    ConnectionErrorView {

    fun showContent()

    fun setupAdapter()
}