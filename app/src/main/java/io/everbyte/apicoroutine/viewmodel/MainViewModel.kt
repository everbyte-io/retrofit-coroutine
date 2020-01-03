package io.everbyte.apicoroutine.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.everbyte.apicoroutine.extension.launch
import io.everbyte.apicoroutine.model.NetworkState
import io.everbyte.apicoroutine.network.NetworkService
import io.everbyte.apicoroutine.network.Repository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * Created by Thomas Chen on 24-12-2019.
 */

class MainViewModel : ViewModel() {

    val imageData = MutableLiveData<List<String>>()
    val networkState = MutableLiveData<NetworkState>()

//    fun getDataOld() {
//        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
//            networkState.value = NetworkState.Failed(throwable.message ?: "Failed loading")
//        }) {
//            networkState.value = NetworkState.Loading()
//
//            val data1 = async { NetworkService.apiService.getImage() }
//            val data2 = async { NetworkService.apiService.getImage() }
//            val data3 = async { NetworkService.apiService.getImage() }
//
//            imageData.value =
//                listOf(data1.await(), data2.await(), data3.await()).map { it.imageUrl }
//
//            networkState.value = NetworkState.Success()
//        }
//    }

    fun getData() {
        launch({
            networkState.value = NetworkState.Loading()

//            val data1 = async { Repository.getImageData() }
//            val data2 = async { Repository.getImageData() }
//            val data3 = async { Repository.getImageData() }

            val data1 = async { NetworkService.apiService.getImage() }
            val data2 = async { NetworkService.apiService.getImage() }
            val data3 = async { NetworkService.apiService.getImage() }

            imageData.value =
                listOf(data1.await(), data2.await(), data3.await()).map { it.imageUrl }

            networkState.value = NetworkState.Success()
        }, {
            networkState.value = NetworkState.Failed(it.message ?: "Failed loading")
        }, {
            Log.d(this.javaClass.simpleName, "onComplete executed")
        })
    }

}