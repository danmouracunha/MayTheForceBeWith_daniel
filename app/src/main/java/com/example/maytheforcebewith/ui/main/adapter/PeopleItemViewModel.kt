package com.example.maytheforcebewith.ui.main.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.maytheforcebewith.base.model.BaseViewModel
import com.example.maytheforcebewith.base.model.People
import com.example.maytheforcebewith.util.parseDate

class PeopleItemViewModel : BaseViewModel(){
    private val characterNameLiveData = MutableLiveData<String>()
    private val characterCreationLiveData = MutableLiveData<String>()
    private val characterMoviesLiveData = MutableLiveData<String>()

    fun bind(people: People) {
        characterNameLiveData.postValue(people.name)
        characterCreationLiveData.postValue("Created in ${people.created.parseDate()}" )
        characterMoviesLiveData.postValue("Appears in ${people.films.size} movies")
    }

    fun getCharacterName(): LiveData<String> {
        return characterNameLiveData
    }
    fun getCharacterCreation(): LiveData<String> {
        return characterCreationLiveData
    }
    fun getCharacterMovies(): LiveData<String> {
        return characterMoviesLiveData
    }
}