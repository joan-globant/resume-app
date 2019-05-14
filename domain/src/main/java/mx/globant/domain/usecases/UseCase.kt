package mx.globant.domain.usecases

import mx.globant.data.network.BaseCallback

interface UseCase<M> {

    fun execute(callback: BaseCallback<M>)
}