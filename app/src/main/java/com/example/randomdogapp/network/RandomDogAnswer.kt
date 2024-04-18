package com.example.randomdogapp.network

// класс данных
// мы здесь описали какие данные мы ожидаем в случае ответа от сервера
// а точнее, мы указали какие будут поля и какой тип данных мы ожидаем в этих полях
data class RandomDogAnswer(
    val message: String,
    val status: String
)