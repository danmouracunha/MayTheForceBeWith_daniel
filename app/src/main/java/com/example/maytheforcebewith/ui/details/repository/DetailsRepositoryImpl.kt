package com.example.maytheforcebewith.ui.details.repository

import com.example.maytheforcebewith.base.model.UseCaseResult
import com.example.maytheforcebewith.base.model.People
import com.example.maytheforcebewith.network.PeopleApi

open class DetailsRepositoryImpl(private val peopleApi: PeopleApi) : DetailsRepository {
    override suspend fun postFavorite(favoritePerson: People): UseCaseResult<Int> {
        return try {
            val request = peopleApi.postFavorite(favoritePerson)
            if (request.isSuccessful) {
                UseCaseResult.Success(request.code())
            } else {
                UseCaseResult.Error(Throwable(request.message()))
            }
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }

    override suspend fun getPerson(personUrl: String): UseCaseResult<People> {
        return try {
            val result = peopleApi.getPerson(personUrl)
            if (result.isSuccessful) {
                UseCaseResult.Success(result.body()!!)
            } else {
                UseCaseResult.Error(Throwable(result.message()))
            }
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }
}