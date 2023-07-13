package com.example.futuro058.Modelo.remote

import com.example.futuro058.Modelo.remote.frominternet.CourseDetail
import com.example.futuro058.Modelo.remote.frominternet.Courses
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface CentroFuturoApi {


    // listado de cursos
    @GET("courses")
    suspend fun fecthCoursesList(): Response<List<Courses>>


    // seleccionar uno

    @GET("courses/{id}")
    suspend fun fechCourseDetail(@Path("id")id:String): Response<CourseDetail>






}