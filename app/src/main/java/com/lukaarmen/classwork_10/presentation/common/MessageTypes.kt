package com.lukaarmen.classwork_10.presentation.common

import androidx.annotation.DrawableRes
import com.lukaarmen.classwork_10.R

enum class MessageTypes(val type: String, val message: String?, @DrawableRes val icon: Int?) {
    TEXT("text", null, null),
    VOICE("voice", "sent a voice message", R.drawable.ic_voice_message),
    ATTACHMENT("attachment", "sent an attachment", R.drawable.ic_attachment)
}