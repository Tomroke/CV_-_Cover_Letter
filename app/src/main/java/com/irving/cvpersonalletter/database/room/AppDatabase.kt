package com.irving.cvpersonalletter.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.irving.cvpersonalletter.database.CVData

@Database(entities = [CVData::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase(){
    abstract fun cvDao(): CVDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java,"cv_cover_letter_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}