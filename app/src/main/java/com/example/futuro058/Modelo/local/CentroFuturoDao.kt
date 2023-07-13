package com.example.futuro058.Modelo.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.futuro058.Modelo.local.entities.CoursesDetailEntity
import com.example.futuro058.Modelo.local.entities.CoursesEntity


@Dao
interface CentroFuturoDao {


    // insertar lista

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCourses(listCourses: List<CoursesEntity>)


    @Query("SELECT * FROM courses_list_table  ORDER BY id ASC")
  fun getAllCourses(): LiveData<List<CoursesEntity>>


    // INSERTA UN ELEMENTO

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourseDetail(course: CoursesDetailEntity)


    // da error por momentanemante no se ocupa
   //@Query("SELECT * FROM course_details_table  ORDER BY id ASC")
   //suspend fun  getCourseDetailByID(id:String): CoursesDetailEntity?



}