package com.lukaarmen.classwork_10.presentation.chat

import androidx.lifecycle.ViewModel
import com.lukaarmen.classwork_10.domain.model.Message
import com.lukaarmen.classwork_10.domain.usecase.GetAllMessagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllMessagesUseCase: GetAllMessagesUseCase
): ViewModel() {

    private val _messagesFlow = MutableStateFlow(MessagesState())
    val messagesFlow get() = _messagesFlow.asStateFlow()

    suspend fun getAllMessages() {
        getAllMessagesUseCase().collect {
            it.apply {
                val currentState = _messagesFlow.value
                onSuccess { messagesList ->
                    _messagesFlow.emit(currentState.copy(messages = messagesList))
                }
                onFailure { error ->
                    _messagesFlow.emit(currentState.copy(error = error))
                }
                onLoader { isLoading ->
                    _messagesFlow.emit(currentState.copy(isLoading = isLoading))
                }
            }
        }
    }

}

data class MessagesState(
    val messages: List<Message>? = null,
    val error: String? = null,
    val isLoading: Boolean? = null
)