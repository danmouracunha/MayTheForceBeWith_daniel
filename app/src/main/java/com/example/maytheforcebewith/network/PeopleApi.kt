package com.example.maytheforcebewith.network

import com.example.maytheforcebewith.BuildConfig.WEBHOOK_URL
import com.example.maytheforcebewith.base.model.DataApi
import com.example.maytheforcebewith.base.model.People
import com.example.maytheforcebewith.util.URL_PERSON
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface PeopleApi {

    @GET(URL_PERSON)
    suspend fun getPeople(): Response<DataApi>

    @GET
    suspend fun getPeople(@Url nextUrl : String): Response<DataApi>

    @GET
    suspend fun getPerson(@Url personUrl : String): Response<People>

    @POST
    suspend fun postFavorite(@Body favoritePerson : People, @Url webhookUrl: String = WEBHOOK_URL): Response<Void>
}