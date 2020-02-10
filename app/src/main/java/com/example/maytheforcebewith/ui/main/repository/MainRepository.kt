package com.example.maytheforcebewith.ui.main.repository

import com.example.maytheforcebewith.base.model.DataApi
import com.example.maytheforcebewith.network.PeopleApi

open class MainRepository(private val peopleApi: PeopleApi) {
    suspend fun getPeopleNextPage(): DataApi {
        return peopleApi.getPeople().body()!!
    }
    suspend fun getPeopleNextPage(nextUrl: String): DataApi {
        return peopleApi.getPeople(nextUrl).body()!!
    }
}