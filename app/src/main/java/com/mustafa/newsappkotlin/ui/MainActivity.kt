package com.mustafa.newsappkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mustafa.newsappkotlin.R
import com.mustafa.newsappkotlin.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}