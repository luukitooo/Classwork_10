package com.lukaarmen.classwork_10.domain.model

data class Message(
    val id: Long?,
    val email: String?,
    val firstName: String?,
    val lastName: String?,
    val avatar: String?,
    val messageType: String?,
    val lastMessage: String?,
    val unreadMessages: Int?,
    val isTyping: Boolean?,
    val updatedDate: Long?
)
