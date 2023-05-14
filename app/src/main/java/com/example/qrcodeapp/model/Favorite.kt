package com.example.qrcodeapp.model

import androidx.room.*

@Entity(tableName = "favorites")
data class FavoriteItem(
    @PrimaryKey val id: Int,
    val name: String,
    var isFavorite: Boolean = false,
    val description: String,
    val date: String
)

// Определение DAO для работы с таблицей избранного
@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favoriteItem: FavoriteItem)
}

// Создание объекта базы данных
@Database(entities = [FavoriteItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}
