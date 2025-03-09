package com.example.core_db.di

import android.content.Context
import androidx.room.Room
import com.example.core_db.VacancyDB
import com.example.core_db.VacancyDao
import com.example.core_db.repository.VacancyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): VacancyDB {
        return Room.databaseBuilder(
            context,
            VacancyDB::class.java,
            "video_database"
        ).build()
    }

    @Provides
    fun provideVideoDao(database: VacancyDB): VacancyDao {
        return database.vacancyDao()
    }

    @Provides
    @Singleton
    fun provideVacancyRepository(dao: VacancyDao): VacancyRepository {
        return VacancyRepository(dao)
    }
}