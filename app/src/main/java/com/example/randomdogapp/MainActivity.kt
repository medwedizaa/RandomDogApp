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
import com.squareup.picasso.Picasso

// главная и единственная "активность" этого проекта
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // привязка файла верстки к активити
        // или с другой строны, "наполнение" нашей активити версткой из файла activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // создание экземпляра класса для работы с сетевым клиентом
        val networkClient: NetworkClient = NetworkClient()
        // инициализация, то есть создание и настройка нашего клиента
        networkClient.initClient()

        // добавление "слушателя" кликов для кнопки new_dog
        binding.newDog.setOnClickListener {
            //по клику на кнопку, у клиента будет запрошено действие на отправку запроса и получение информации от сервера
            networkClient.getDog { url -> // когда сетевой клиент вызовет колбек, этот колбек вернут сюда строку-адрес изображения
                // инструкция для библиотеки Picasso: загрузить картинку по указанному адресу и поместить ее в указанную ImageView
                Picasso.get().load(url).into(binding.dogImage)
            }
        }
    }
}