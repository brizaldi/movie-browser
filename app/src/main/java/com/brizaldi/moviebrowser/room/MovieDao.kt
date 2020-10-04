package com.brizaldi.moviebrowser.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.brizaldi.moviebrowser.models.entity.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieList(movies: List<Movie>)

    @Update
    fun updateMovie(movie: Movie)

    @Query("SELECT * FROM Movie WHERE id = :id_")
    fun getMovie(id_: Int): Movie

    @Query("SELECT * FROM Movie WHERE page = :page_")
    fun getMovieList(page_: Int): LiveData<List<Movie>>

    @Query("DELETE FROM Movie")
    fun nukeTable()
}