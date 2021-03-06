package com.example.maytheforcebewith.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.maytheforcebewith.base.model.BaseViewModel
import com.example.maytheforcebewith.base.model.DataApi
import com.example.maytheforcebewith.base.model.People
import com.example.maytheforcebewith.network.PeopleApi
import com.example.maytheforcebewith.ui.main.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel : BaseViewModel() {
    @Inject
    lateinit var peopleApi: PeopleApi

    private val repository by lazy { MainRepository(peopleApi) }

    val peopleList = MutableLiveData<List<People>>().apply { value = mutableListOf() }
    val nextUrl = MutableLiveData<String>().apply { value = "firstPage" }
    val offset = MutableLiveData<Int>().apply { value = 0 }

    init {
        get()
    }

    fun get() {
        viewModelScope.launch {

            val result = withContext(Dispatchers.IO) {
                when {
                    nextUrl.value == "firstPage" -> repository.getPeopleNextPage()
                    !nextUrl.value.isNullOrBlank() -> {
                        repository.getPeopleNextPage(nextUrl.value!!)
                    }
                    else -> Throwable("End of list")
                }
            }
            if (result is DataApi) {
                peopleList.value = result.results
                offset.value?.plus(result.results.size)
                nextUrl.value = result.nextUrl

            }
        }
    }
}