package com.lukaarmen.classwork_10.di

import com.lukaarmen.classwork_10.data.repository.MessagesRepositoryImpl
import com.lukaarmen.classwork_10.domain.repository.MessagesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMessagesRepositoryImpl(
        messagesRepositoryImpl: MessagesRepositoryImpl
    ): MessagesRepository

}