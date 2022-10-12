package com.lukaarmen.classwork_10.data.remote.model

import com.google.gson.annotations.SerializedName
import com.lukaarmen.classwork_10.domain.model.Message

data class MessageDto(
    val id: Long?,
    val email: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("last_name")
    val lastName: String?,
    val avatar: String?,
    @SerializedName("message_type")
    val messageType: String?,
    @SerializedName("last_message")
    val lastMessage: String?,
    @SerializedName("unrea_message")
    val unreadMessages: Int?,
    @SerializedName("is_typing")
    val isTyping: Boolean?,
    @SerializedName("updated_date")
    val updatedDate: Long?
) {

    fun toMessage() = Message(
        id = id,
        email = email,
        firstName = firstName,
        lastName = lastName,
        avatar = avatar,
        messageType = messageType,
        lastMessage = lastMessage,
        unreadMessages = unreadMessages,
        isTyping = isTyping,
        updatedDate = updatedDate
    )

}
