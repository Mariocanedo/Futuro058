package com.example.futuro058.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.futuro058.Modelo.CentroFuturoRepository
import com.example.futuro058.Modelo.local.database.CoursesDataBase
import com.example.futuro058.Modelo.local.entities.CoursesDetailEntity
import com.example.futuro058.Modelo.local.entities.CoursesEntity
import kotlinx.coroutines.launch

class CoursesViewModel (application: Application): AndroidViewModel(application){

    // conexion repositorio
   private val repository : CentroFuturoRepository

   // entidad
   private val courseDetailLiveData = MutableLiveData<CoursesDetailEntity>()

   private  var idSelected: String ="-1"

    init{
    val bd= CoursesDataBase.getDataBase(application)
    val  centroFuturoDao = bd.getCentroFuturoDao()

        repository = CentroFuturoRepository(centroFuturoDao)

        // lama el método del respositorio
        viewModelScope.launch {

            repository.fechCourses()
        }
    }

    // listado de elementos

  fun getCourseList(): LiveData<List<CoursesEntity>> = repository.coursesListLiveData

    // obtener el detalle envuelto en liveData
    fun getCourseDetail(): LiveData<CoursesDetailEntity> = courseDetailLiveData


    // funcion para seleccionar elemento

 fun getCourseDetailByIDFromInternet(id:String) = viewModelScope.launch {

     val courseDetail = repository.fetchCourseDetail(id)
     courseDetail?.let {

         courseDetailLiveData.postValue(it)
     }
 }


}