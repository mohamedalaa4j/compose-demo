package com.example.compose

import kotlinx.serialization.Serializable

sealed class Screen {

    @Serializable
    object SplashScreen

    @Serializable
    object LoginScreen

    @Serializable
    object ScreenA

    @Serializable
    data class ScreenB(val name: String)
}