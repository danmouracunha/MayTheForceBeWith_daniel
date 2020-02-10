package com.example.maytheforcebewith.ui.main.repository

import com.example.maytheforcebewith.base.model.UseCaseResult
import com.example.maytheforcebewith.base.model.Data

interface MainRepository{
    open suspend fun getPeople() : UseCaseResult<Data>
    open suspend fun getPeople(nextUrl: String) : UseCaseResult<Data>
}