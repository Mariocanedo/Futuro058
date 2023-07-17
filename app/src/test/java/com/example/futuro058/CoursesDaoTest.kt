package com.example.futuro058


import android.content.Context
import android.os.Build.VERSION_CODES.Q
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.futuro058.Modelo.CentroFuturoRepository
import com.example.futuro058.Modelo.local.CentroFuturoDao
import com.example.futuro058.Modelo.local.database.CoursesDataBase
import com.example.futuro058.Modelo.local.entities.CoursesDetailEntity
import com.example.futuro058.Modelo.local.entities.CoursesEntity
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(sdk=[Q], manifest = Config.NONE)
class CoursesDaoTest {


    // referencias
    private lateinit var coursesDaoTest : CentroFuturoDao
    private lateinit var db: CoursesDataBase

    private lateinit var  coursesRepositoryMock: CentroFuturoRepository
    @Before
        fun setUp2(){

        val context= ApplicationProvider.getApplicationContext<Context>()
        db= Room.inMemoryDatabaseBuilder(context,CoursesDataBase::class.java).build()
        coursesDaoTest= db.getCentroFuturoDao()
        // inicializar el mock
        coursesRepositoryMock = Mockito.mock(CentroFuturoRepository::class.java)

//        Mockito.`when`( coursesRepositoryMock.coursesListLiveData()).thenReturn(listOf(
//            CoursesEntity("43", "Prueba1","test1","url",4,"march"),
//            CoursesEntity("44", "Prueba2","test2","url",4,"march"),

      //  ))

    }




    @Before
    fun setUp(){
        val context= ApplicationProvider.getApplicationContext<Context>()
        db= Room.inMemoryDatabaseBuilder(context,CoursesDataBase::class.java).build()
        coursesDaoTest= db.getCentroFuturoDao()

    }



    @After
    fun shutDown(){

        db.close()
    }


// testear insertar una lista de courses
    @Test
    fun insertCoursesList()= runBlocking {

        val coursesEntity= listOf(

            CoursesEntity("43", "Prueba1","test1","url",4,"march"),
            CoursesEntity("44", "Prueba2","test2","url",4,"march"),

        )
       coursesDaoTest.insertAllCourses(coursesEntity)
    val coursesLiveData = coursesDaoTest.getAllCourses()
    val courseList : List<CoursesEntity> = coursesLiveData.value?: emptyList()

    // verificamos que la lista no este vacia

    assertThat(courseList, not(emptyList()))
    assertThat(courseList.size, equalTo(2))
    }


    // inserta y trae un curso por id
      @Test
      fun inserDetailCourses() = runBlocking {


          val courseDetail= CoursesDetailEntity(

              "2",
              "Curso Test 3",
              "text unitarios",
              "url",
              5,
              "March",
              "developer",
              true,
               "presencial",
              "November"

          )
          coursesDaoTest.insertCourseDetail(courseDetail)
          val courseLiveData = coursesDaoTest.getCourseDetailByID("2")
          val courseValue = courseLiveData.value

          assertThat( courseValue?.id, equals("2"))
          assertThat(courseValue?.weeks, equalTo(5))

      }



}