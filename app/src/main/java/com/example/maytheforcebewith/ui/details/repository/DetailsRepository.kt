package com.example.maytheforcebewith.ui.details.repository

import com.example.maytheforcebewith.base.model.People
import com.example.maytheforcebewith.network.PeopleApi

open class DetailsRepository(private val peopleApi: PeopleApi) {
    suspend fun postFavorite(favoritePerson: People): Int {
        val request = peopleApi.postFavorite(favoritePerson)
        return request.code()
    }

    suspend fun getPerson(personUrl: String): People {
        val result = peopleApi.getPerson(personUrl)
        return result.body()!!
    }
}