package com.example.mvvmtodoapp.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmtodoapp.data.TodoDao
import com.example.mvvmtodoapp.data.TodoDatabase
import com.example.mvvmtodoapp.data.TodoRepository
import com.example.mvvmtodoapp.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTodoRepository(dao: TodoDao): TodoRepository = TodoRepositoryImpl(dao)

    @Provides
    @Singleton
    fun provideToDoDatabase(@ApplicationContext context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            name = "data"

        ).build()
    }
    @Provides
    @Singleton
    fun provideToDoDao(db: TodoDatabase): TodoDao = db.dao


}