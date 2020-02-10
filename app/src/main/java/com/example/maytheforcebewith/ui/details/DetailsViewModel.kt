package com.example.maytheforcebewith.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.maytheforcebewith.base.model.BaseViewModel
import com.example.maytheforcebewith.base.model.People
import com.example.maytheforcebewith.network.PeopleApi
import com.example.maytheforcebewith.ui.details.repository.DetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailsViewModel : BaseViewModel() {
    @Inject
    lateinit var peopleApi: PeopleApi

    private val repository by lazy { DetailsRepository(peopleApi) }

    val personData = MutableLiveData<People>().apply { value = null }

    val successRequest = MutableLiveData<Int>().apply { value = 0 }

    fun getPerson(personUrl: String) {
        viewModelScope.launch {

            val result = withContext(Dispatchers.IO) {
                repository.getPerson(personUrl)
            }
            if (result is People) {
                personData.value = result
            }
        }
    }

    fun postFavorite() {
        viewModelScope.launch {

            val result = withContext(Dispatchers.IO) {
                repository.postFavorite(personData.value!!)
            }
            if (result is Int && result == 200) {
                successRequest.value = 1
            }

        }
    }
}
