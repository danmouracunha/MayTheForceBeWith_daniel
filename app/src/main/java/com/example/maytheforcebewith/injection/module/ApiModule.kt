package com.example.maytheforcebewith.injection.module

import com.example.maytheforcebewith.BuildConfig
import com.example.maytheforcebewith.BuildConfig.API_URL
import com.example.maytheforcebewith.network.PeopleApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
object ApiModule {
    /**
     * Provides the PeopleApi service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the PeopleApi service implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun providePeopleApi(retrofit: Retrofit): PeopleApi {
        return retrofit.create(PeopleApi::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        val gson = GsonBuilder()
            .setLenient()
            .create()

        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)

        val retrofit = Retrofit.Builder().baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson)).client(httpClient.build())
            .build()

        return retrofit
    }
}