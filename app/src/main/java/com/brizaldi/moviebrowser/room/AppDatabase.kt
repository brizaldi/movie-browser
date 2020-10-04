package com.brizaldi.moviebrowser.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brizaldi.moviebrowser.models.entity.Genre
import com.brizaldi.moviebrowser.models.entity.Movie
import com.brizaldi.moviebrowser.models.entity.Tv
import com.brizaldi.moviebrowser.room.converters.*

@Database(entities = [(Movie::class), (Tv::class), (Genre::class)],
    version = 3, exportSchema = false)
@TypeConverters(value = [(StringListConverter::class), (IntegerListConverter::class),
    (KeywordListConverter::class), (VideoListConverter::class), (ReviewListConverter::class)])
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvDao
    abstract fun genreDao(): GenreDao
}