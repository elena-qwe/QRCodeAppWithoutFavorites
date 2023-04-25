package com.example.qrcodeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qrcodeapp.model.Favorite
import com.example.qrcodeapp.model.Scan

class FavoritesViewModel: ViewModel() {

    private val favoriteCodes = mutableListOf<Favorite>()

    fun addFavorites(favorite: Favorite) {
        favoriteCodes.add(favorite)
    }

    fun removeFavorites(favorite: Favorite) {
        favoriteCodes.remove(favorite)
    }

    fun getFavoriteCodes(): List<Favorite> {
        return favoriteCodes
    }

}