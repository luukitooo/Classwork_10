package com.lukaarmen.classwork_10.data.remote.api

import com.lukaarmen.classwork_10.data.common.MessagesApiUtil
import com.lukaarmen.classwork_10.data.remote.model.MessageDto
import retrofit2.Response
import retrofit2.http.GET

interface MessagesApi {

    @GET(MessagesApiUtil.ENDPOINT_MESSAGES)
    suspend fun getAllMessages(): Response<List<MessageDto>>

}