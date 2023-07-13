package com.example.futuro058.Modelo.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.futuro058.Modelo.local.CentroFuturoDao
import com.example.futuro058.Modelo.local.entities.CoursesDetailEntity
import com.example.futuro058.Modelo.local.entities.CoursesEntity


@Database(entities = [CoursesEntity::class, CoursesDetailEntity::class], version = 1,
    exportSchema = false)
abstract class CoursesDataBase : RoomDatabase(){

    // representacion del dao
    abstract fun getCentroFuturoDao() : CentroFuturoDao

    companion object{

        @Volatile
        private var
                INSTANCE : CoursesDataBase? = null
        fun getDataBase(context: Context) : CoursesDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CoursesDataBase::class.java, "courses_db_058")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}