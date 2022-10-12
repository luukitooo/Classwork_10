package com.lukaarmen.classwork_10.di

import com.lukaarmen.classwork_10.data.common.MessagesApiUtil
import com.lukaarmen.classwork_10.data.remote.api.MessagesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(MessagesApiUtil.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMessagesApi(
        retrofit: Retrofit
    ): MessagesApi {
        return retrofit.create(MessagesApi::class.java)
    }

}