package com.example.maytheforcebewith.network

import com.example.maytheforcebewith.BuildConfig.WEBHOOK_URL
import com.example.maytheforcebewith.base.model.Data
import com.example.maytheforcebewith.base.model.People
import com.example.maytheforcebewith.util.URL_PERSON
import retrofit2.Response
import retrofit2.http.*

interface PeopleApi {

    /**
     * Get the list of the people from the API
     */
    @GET(URL_PERSON)
    suspend fun getPeople(): Response<Data>

    /**
     * Get the list of the people from the API
     * @param nextUrl Url for the next page of results from the API
     */
    @GET
    suspend fun getPeople(@Url nextUrl : String): Response<Data>

    /**
     * Get details of a character from the API
     */
    @GET
    suspend fun getPerson(@Url personUrl : String): Response<People>

    /**
     * Post character as favorite
     */
    @POST
    suspend fun postFavorite(@Body favoritePerson : People, @Url webhookUrl: String = WEBHOOK_URL): Response<Void>
}