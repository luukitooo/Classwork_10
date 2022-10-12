package com.lukaarmen.classwork_10.domain.repository

import com.lukaarmen.classwork_10.domain.common.Resource
import com.lukaarmen.classwork_10.domain.model.Message
import kotlinx.coroutines.flow.Flow

interface MessagesRepository {

    suspend fun getAllMessages(): Flow<Resource<List<Message>>>

}