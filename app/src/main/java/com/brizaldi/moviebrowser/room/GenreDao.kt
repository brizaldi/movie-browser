package com.brizaldi.moviebrowser.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.brizaldi.moviebrowser.models.entity.Genre

@Dao
interface GenreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenreList(genres: List<Genre>)

    @Update
    fun updateGenre(genre: Genre)

    @Query("SELECT * FROM Genre WHERE id = :id_")
    fun getGenre(id_: Int): Genre

    @Query("SELECT * FROM Genre")
    fun getGenreList(): LiveData<List<Genre>>
}