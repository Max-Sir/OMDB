package com.max.sir.omdb.core

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.max.sir.omdb.search.data.cache.MovieDao
import com.max.sir.omdb.search.data.cache.MovieEntity
import com.max.sir.omdb.search.data.cache.MovieEntityTypeConverter

@Database(entities = [MovieEntity::class], version = 2, exportSchema = false)
@TypeConverters(MovieEntityTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}