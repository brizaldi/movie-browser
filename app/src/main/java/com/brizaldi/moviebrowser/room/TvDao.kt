package com.brizaldi.moviebrowser.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.brizaldi.moviebrowser.models.entity.Tv

@Dao
interface TvDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTv(tvs: List<Tv>)

    @Update
    fun updateTv(tv: Tv)

    @Query("SELECT * FROM Tv WHERE id = :id_")
    fun getTv(id_: Int): Tv

    @Query("SELECT * FROM Tv WHERE page = :page_")
    fun getTvList(page_: Int): LiveData<List<Tv>>

    @Query("DELETE FROM Tv")
    fun nukeTable()
}