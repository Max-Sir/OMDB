package com.max.sir.omdb.movie_details.data.cache

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MovieDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(detail: MovieDetailEntity)

    @Query("SELECT * FROM movie_details WHERE id = :id")
    fun getDetailById(id: String): LiveData<MovieDetailEntity?>
}