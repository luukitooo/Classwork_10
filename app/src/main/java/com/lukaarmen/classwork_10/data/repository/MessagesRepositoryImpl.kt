package com.lukaarmen.classwork_10.data.repository

import com.lukaarmen.classwork_10.data.common.ResponseHandler
import com.lukaarmen.classwork_10.data.remote.api.MessagesApi
import com.lukaarmen.classwork_10.domain.common.Resource
import com.lukaarmen.classwork_10.domain.common.mapSuccess
import com.lukaarmen.classwork_10.domain.model.Message
import com.lukaarmen.classwork_10.domain.repository.MessagesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MessagesRepositoryImpl @Inject constructor(
    private val api: MessagesApi,
    private val handler: ResponseHandler
) : MessagesRepository {

    override suspend fun getAllMessages(): Flow<Resource<List<Message>>> {
        return handler.safeApiCall {
            api.getAllMessages()
        }.map { resource ->
            resource.mapSuccess { dto ->
                dto.toMessage()
            }
        }
    }

}