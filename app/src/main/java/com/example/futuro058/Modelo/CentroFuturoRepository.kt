package com.example.futuro058.Modelo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.futuro058.Modelo.local.CentroFuturoDao
import com.example.futuro058.Modelo.local.entities.CoursesDetailEntity
import com.example.futuro058.Modelo.remote.RetrofitClient


class CentroFuturoRepository (private val centroFuturoDao: CentroFuturoDao) {

    //retrofit cliente
    private val networkService = RetrofitClient.retrofitInstance()

    // dao

    val coursesListLiveData = centroFuturoDao.getAllCourses()

    //Variable local
    val courseDetailLiveData = MutableLiveData<CoursesDetailEntity>()




    // insertar el listado de cursos
    suspend fun  fechCourses(){

        val service = kotlin.runCatching { networkService.fecthCoursesList()}

        service.onSuccess {

            when(it.code()){
                in 200..299-> it.body()?.let {
               // insertando la lista de cursos
                    centroFuturoDao.insertAllCourses(fromInternetToCoursesEntity(it))
                }

                else -> Log.d("Repo", "${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("Error","${it.message}")
            }


        }



    }


    // insertar uan tarea

    suspend fun fetchCourseDetail(id: String): CoursesDetailEntity? {
        val service = kotlin.runCatching { networkService.fechCourseDetail(id) }
        return service.getOrNull()?.body()?.let { courseDetail ->
            // guardp los datos que viene del mapper y luego se los paso a dao directo
            val courseDetailEntity = fromInternetToCourseDetailEntity(courseDetail)
            //inserto los detalles de los curso DEL REPOSITORIO
            centroFuturoDao.insertCourseDetail(courseDetailEntity)
            courseDetailEntity
        }
    }

//    suspend fun getCourseDetailByID(id: String): CoursesDetailEntity? {
//        val courseDetail = centroFuturoDao.getCourseDetailByID(id)
//        Log.d("CentroFuturoRepository", "CourseDetailEntity: $courseDetail")
//        return courseDetail
//    }








}