package com.example.tubongeapp.utils

sealed class TubongeEvents {
    data class Snackbar(val message: String, val action: String?): TubongeEvents()

    data class Navigate(val route: String): TubongeEvents()

    object PopBackStack: TubongeEvents()
}