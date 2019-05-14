package mx.globant.challenge.presenter


abstract class BasePresenter<V> {

    protected var view: V? = null

    fun initView(view: V) {
        this.view = view
    }

    fun destroy() {
        view = null
    }
}