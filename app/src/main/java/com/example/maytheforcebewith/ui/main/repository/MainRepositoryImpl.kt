package com.example.maytheforcebewith.ui.main.repository

import com.example.maytheforcebewith.base.model.UseCaseResult
import com.example.maytheforcebewith.base.model.Data
import com.example.maytheforcebewith.network.PeopleApi

open class MainRepositoryImpl(private val peopleApi: PeopleApi) : MainRepository{
    override suspend fun getPeople(): UseCaseResult<Data> {
        return try{
            val result = peopleApi.getPeople()
            if (result.isSuccessful){
                UseCaseResult.Success(result.body()!!)
            } else{
                UseCaseResult.Error(Throwable(result.message()))
            }
        }catch (ex : Exception){
            UseCaseResult.Error(ex)
        }
    }
    override suspend fun getPeople(nextUrl: String): UseCaseResult<Data> {
        return try{
            val result = peopleApi.getPeople(nextUrl)
            if (result.isSuccessful){
                UseCaseResult.Success(result.body()!!)
            } else{
                UseCaseResult.Error(Throwable(result.message()))
            }
        }catch (ex : Exception){
            UseCaseResult.Error(ex)
        }
    }
}