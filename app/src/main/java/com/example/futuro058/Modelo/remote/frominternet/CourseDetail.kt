package com.example.futuro058.Modelo.remote.frominternet

data class CourseDetail (
    val id:String,
    val title:String,
    val previewDescription:String,
    val image:String,
    val weeks:Int,
    val tuition:String,
    val minimumSkill:String,
    val scholarshipsAvailable:Boolean,
    val modality:String,
    val start:String
)