package com.example.qrcodeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qrcodeapp.model.FavoriteItem
import com.example.qrcodeapp.model.Scan

class FavoritesViewModel: ViewModel() {

    private val favoriteCodes = mutableListOf<FavoriteItem>()

    fun addFavorites(favoriteItem: FavoriteItem) {
        favoriteCodes.add(favoriteItem)
    }

    fun removeFavorites(favoriteItem: FavoriteItem) {
        favoriteCodes.remove(favoriteItem)
    }

    fun getFavoriteCodes(): List<FavoriteItem> {
        return favoriteCodes
    }

}