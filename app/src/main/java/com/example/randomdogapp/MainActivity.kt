package com.example.randomdogapp

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.randomdogapp.databinding.ActivityMainBinding
import com.example.randomdogapp.network.NetworkClient

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val networkClient: NetworkClient = NetworkClient()
        networkClient.initClient()

        binding.newDog.setOnClickListener {
            Log.i("DOG APP DEBUG", "the button is pressed")
            networkClient.getDog()
        }
    }
}