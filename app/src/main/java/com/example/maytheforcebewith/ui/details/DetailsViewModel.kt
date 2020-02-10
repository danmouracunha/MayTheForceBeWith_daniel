package com.example.maytheforcebewith.ui.details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.maytheforcebewith.base.model.BaseViewModel
import com.example.maytheforcebewith.base.model.UseCaseResult
import com.example.maytheforcebewith.base.model.People
import com.example.maytheforcebewith.network.PeopleApi
import com.example.maytheforcebewith.ui.details.repository.DetailsRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailsViewModel : BaseViewModel() {
    @Inject
    lateinit var peopleApi: PeopleApi

    private val repository by lazy { DetailsRepositoryImpl(peopleApi) }

    val personData = MutableLiveData<People>().apply { value = null }

    val successRequest = MutableLiveData<Int>().apply { value = 0 }

    fun getPerson(personUrl: String) {
        viewModelScope.launch {

            val result = withContext(Dispatchers.IO) {
                repository.getPerson(personUrl)
            }

            when(result){
                is UseCaseResult.Success -> {
                    personData.value = result.data
                    Log.d("DATA", result.data.toString())
                }
                is UseCaseResult.Error -> {
                    Log.d("ERROR", result.exception.message!!)
                }
            }
        }
    }

    fun postFavorite() {
        viewModelScope.launch {

            val result = withContext(Dispatchers.IO) {
                repository.postFavorite(personData.value!!)
            }

            when(result){
                is UseCaseResult.Success -> {
                    successRequest.value = 1
                }
                is UseCaseResult.Error -> {
                    successRequest.value = -1
                    Log.d("ERROR", result.exception.message!!)
                }
            }
        }
    }
}
