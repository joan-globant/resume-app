package mx.globant.data.network


interface BaseCallback<M> {

    fun onSuccess(model: M)

    fun onError()
}