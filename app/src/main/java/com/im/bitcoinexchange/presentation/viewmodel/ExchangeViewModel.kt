package com.im.bitcoinexchange.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LoadState
import com.im.bitcoinexchange.domain.model.Exchange
import com.im.bitcoinexchange.repository.Repository
import com.im.bitcoinexchange.util.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel
@Inject
constructor(
    private val repository: Repository,
) : ViewModel() {

    val exchanges: MutableState<NetworkState<List<Exchange>>?> = mutableStateOf(null)

    private var job: Job? = null

    fun startRunning(){
        job = getExchanges()
    }

    fun stopRunning(){
        job?.cancel()
        job = null
        Log.d("isRunning", "Stopped Running")
    }

    fun getExchanges(): Job {

        return viewModelScope.launch(Dispatchers.IO) {

            while (isActive) {

                try {
                    val response = repository.Exchanges()
                    exchanges.value = NetworkState.Success(response)
                    Log.d("isRunning", "Running")
                } catch (e: Exception) {
                    exchanges.value = NetworkState.Error("${e.message}")
                }

                delay(1000)

            }

        }

    }








}