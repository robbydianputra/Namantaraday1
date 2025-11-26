package com.bagicode.namantaraday1.di

import com.bagicode.namantaraday1.data.remote.api.NamantaraApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val BASE_URL = "project.bagicode.com/smkn8jakarta/api/"

    @Provides
    @Singleton
    fun provideOkHttp() : OkHttpClient =
        OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideNamantaraApi(retrofit: Retrofit): NamantaraApi =
        retrofit.create(NamantaraApi::class.java)

}