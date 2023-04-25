package com.example.qrcodeapp.repository.data.favorite

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.qrcodeapp.model.Favorite

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavorite(favotite: Favorite)

    @Delete
    suspend fun deleteFavorite(favotite: Favorite)

}