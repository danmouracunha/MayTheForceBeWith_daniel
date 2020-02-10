package com.example.maytheforcebewith.ui.details.repository

import com.example.maytheforcebewith.base.model.UseCaseResult
import com.example.maytheforcebewith.base.model.People

interface DetailsRepository {
    suspend fun getPerson(personUrl: String) : UseCaseResult<People>
    suspend fun postFavorite(favoritePerson: People) : UseCaseResult<Int>

}