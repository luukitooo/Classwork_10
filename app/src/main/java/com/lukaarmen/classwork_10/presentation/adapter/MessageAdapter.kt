package com.lukaarmen.classwork_10.presentation.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lukaarmen.classwork_10.R
import com.lukaarmen.classwork_10.databinding.ItemMessageBinding
import com.lukaarmen.classwork_10.domain.model.Message
import com.lukaarmen.classwork_10.presentation.common.MessageTypes
import java.text.SimpleDateFormat

class MessageAdapter : ListAdapter<Message, MessageAdapter.MessageViewHolder>(MessageItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MessageViewHolder(
        ItemMessageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind()
    }

    inner class MessageViewHolder(private val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val message = getItem(adapterPosition)
            binding.apply {
                Glide.with(this.root).load(message.avatar).into(ivUser)
                tvUsername.text = message.firstName.plus(" ").plus(message.lastName)
                tvTime.text = "02:24"
                when (message.messageType) {
                    MessageTypes.TEXT.type -> {
                        ivMessageType.isVisible = false
                        tvLastMessage.text = message.lastMessage
                    }
                    MessageTypes.ATTACHMENT.type -> {
                        ivMessageType.setImageResource(MessageTypes.ATTACHMENT.icon!!)
                        tvLastMessage.text = MessageTypes.ATTACHMENT.message
                    }
                    MessageTypes.VOICE.type -> {
                        ivMessageType.setImageResource(MessageTypes.VOICE.icon!!)
                        tvLastMessage.text = MessageTypes.VOICE.message
                    }
                }
                if ((message.unreadMessages ?: 0) > 0) {
                    tvMessagesCount.text = message.unreadMessages.toString()
                    tvLastMessage.setTypeface(tvLastMessage.typeface, Typeface.BOLD)
                } else {
                    tvMessagesCount.isVisible = false
                }
            }
        }
    }

    private object MessageItemCallback : DiffUtil.ItemCallback<Message>() {
        override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem == newItem
        }
    }

}