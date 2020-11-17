package com.example.superheroes.di

import com.example.superheroes.network.ApiClient
import com.example.superheroes.network.ApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class FirstRetrofitUrl

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class SecondRetrofitUrl

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @FirstRetrofitUrl
    @Provides
    @Singleton
    fun provideRetrofitFirstUrl(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @SecondRetrofitUrl
    @Provides
    @Singleton
    fun provideRetrofitSecondUrl(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jslowinski.github.io/SuperHeroList/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @FirstRetrofitUrl
    @Provides
    @Singleton
    fun provideApiServiceDetail(@FirstRetrofitUrl retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @SecondRetrofitUrl
    @Provides
    @Singleton
    fun provideApiServiceList(@SecondRetrofitUrl retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiDetailClient(@FirstRetrofitUrl apiService: ApiService): ApiClient {
        return ApiClient(apiService)
    }
}