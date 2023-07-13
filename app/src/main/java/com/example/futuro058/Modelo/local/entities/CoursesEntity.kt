package com.example.futuro058.Modelo.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName ="courses_list_table")
data class CoursesEntity(

    @PrimaryKey
val id : String,
val title:String,
val previewDescription: String,
val image: String,
val weeks: Int,
val star: String


        )