package com.example.core_network.di

import com.example.core_network.GoogleDriveApi
import com.example.core_network.repository.GoogleDriveApiRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://drive.usercontent.google.com/"

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideGoogleDriveApiService(retrofit: Retrofit): GoogleDriveApi {
        return retrofit.create(GoogleDriveApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGoogleDriveApiRepository(apiService: GoogleDriveApi): GoogleDriveApiRepository {
        return GoogleDriveApiRepository(apiService)
    }
}