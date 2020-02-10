package com.example.maytheforcebewith.ui.main.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.maytheforcebewith.base.model.BaseViewModel
import com.example.maytheforcebewith.base.model.People

class PeopleItemViewModel : BaseViewModel(){
    private val characterNameLiveData = MutableLiveData<String>()


    fun bind(people: People) {
        characterNameLiveData.postValue(people.name)
    }

    fun getCharacterName(): LiveData<String> {
        return characterNameLiveData
    }
}