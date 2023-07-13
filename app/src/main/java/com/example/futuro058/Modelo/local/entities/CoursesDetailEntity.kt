package com.example.futuro058.Modelo.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "course_details_table")
data class CoursesDetailEntity(

    @PrimaryKey
    val id : String,
    val title:String,
    val previewDescription: String,
    val image: String,
    val weeks: Int,
    val tuition: String,
    val minimumSkill: String,
    val scholarshipAvailable:Boolean,
    val modality: String,
    val star: String

)