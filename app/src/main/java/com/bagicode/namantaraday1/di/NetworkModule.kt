package com.bagicode.namantaraday1.di

import android.content.Context
import com.bagicode.namantaraday1.data.local.datastore.NamantaraPreferences
import com.bagicode.namantaraday1.data.remote.api.NamantaraApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val BASE_URL = "https://project.bagicode.com/smkn8jakarta/api/"

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

    @Provides
    @Singleton
    fun provideUserPreferences(@ApplicationContext context: Context): NamantaraPreferences {
        return NamantaraPreferences(context)
    }
}