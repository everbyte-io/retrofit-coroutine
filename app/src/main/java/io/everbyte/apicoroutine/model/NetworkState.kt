package io.everbyte.apicoroutine.model

/**
 * Created by Thomas Chen on 24-12-2019.
 */

sealed class NetworkState(val message: String) {
    class Loading(message: String = "") : NetworkState(message)
    class Success(message: String = "") : NetworkState(message)
    class Failed(message: String) : NetworkState(message)
}