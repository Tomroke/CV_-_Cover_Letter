package com.irving.cvpersonalletter.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cv_table")
data class CVData(
    @PrimaryKey(autoGenerate = true)
    val cvId: String = "0",

    @ColumnInfo(name = "imageUrl")
    val image: String = "image mock",

    @ColumnInfo(name = "cv_education_title")
    val title: String = "title mock",

    @ColumnInfo(name = "employer")
    val employer: String = "employer mock",

    @ColumnInfo(name = "paragraph_one")
    val paraOne: String = "paragraph one mock",

    @ColumnInfo(name = "paragraph_two")
    val paraTwo: String = "paragraph two mock",

    @ColumnInfo(name = "paragraph_three")
    val paraThree: String = "paragraph three mock"
) {

}
