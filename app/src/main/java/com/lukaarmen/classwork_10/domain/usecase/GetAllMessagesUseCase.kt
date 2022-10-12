package com.lukaarmen.classwork_10.domain.usecase

import com.lukaarmen.classwork_10.domain.repository.MessagesRepository
import javax.inject.Inject

class GetAllMessagesUseCase @Inject constructor(
    private val repository: MessagesRepository
) {

    suspend operator fun invoke() = repository.getAllMessages()

}