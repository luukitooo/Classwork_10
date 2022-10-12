package com.lukaarmen.classwork_10.presentation.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.lukaarmen.classwork_10.databinding.ActivityMainBinding
import com.lukaarmen.classwork_10.presentation.adapter.MessageAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel>()

    private val messageAdapter = MessageAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        observers()

    }

    private fun init() {
        binding.root.apply {
            adapter = messageAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        lifecycleScope.launch {
            viewModel.getAllMessages()
        }
    }

    private fun observers() {
        lifecycleScope.launch {
            viewModel.messagesFlow.collect { messagesState ->
                messagesState.messages?.let { messages ->
                    messageAdapter.submitList(messages)
                }
            }
        }
    }

}