package com.irving.cvpersonalletter.database.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.irving.cvpersonalletter.database.CVData

@Dao
interface CVDatabaseDao {

    @Insert
    fun insert (cv: CVData)

    @Update
    fun update(cv: CVData)

    @Query("SELECT * from cv_table WHERE cvId = :key")
    fun getSingleCV(key: String): CVData?

    @Query("SELECT * FROM cv_table ORDER BY cvId DESC")
    fun getAllCV(): LiveData<List<CVData>>

}
