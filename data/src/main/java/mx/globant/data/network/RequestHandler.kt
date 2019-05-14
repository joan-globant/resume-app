package mx.globant.data.network

import android.net.NetworkInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RequestHandler<E, M>(private val networkManager: NetworkInfo?) {

    fun request(call: Call<E>, callback: BaseCallback<M>, convert: (E) -> M) {
        if (networkManager?.isConnected == true) {
            call.enqueue(object : Callback<E> {
                override fun onResponse(call: Call<E>, response: Response<E>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            callback.onSuccess(convert(it))
                        } ?: callback.onError()
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<E>, t: Throwable) {
                    callback.onError()
                }
            })
        } else {
            callback.onError()
        }
    }
}