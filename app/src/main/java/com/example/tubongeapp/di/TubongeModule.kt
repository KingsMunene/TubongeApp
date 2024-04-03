package com.example.tubongeapp.di

import com.example.tubongeapp.domain.TubongeApiRepoImpl
import com.example.tubongeapp.domain.TubongeApiRepository
import com.example.tubongeapp.retrofit.TubongeApi

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TubongeModule {

    @Provides
    @Singleton
    fun providesTubongeApi(): TubongeApi{
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TubongeApi::class.java)
    }

    @Provides
    @Singleton
    fun providesTubongeRepository(api: TubongeApi): TubongeApiRepository{
        return TubongeApiRepoImpl(api)
    }
}