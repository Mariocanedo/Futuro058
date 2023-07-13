package com.example.futuro058.Modelo

import com.example.futuro058.Modelo.local.entities.CoursesDetailEntity
import com.example.futuro058.Modelo.local.entities.CoursesEntity
import com.example.futuro058.Modelo.remote.frominternet.CourseDetail
import com.example.futuro058.Modelo.remote.frominternet.Courses


fun fromInternetToCoursesEntity(coursesList: List<Courses>): List<CoursesEntity>{

    return coursesList.map {

        CoursesEntity(
            id= it.id,
            title = it.title,
            previewDescription = it.previewDescription,
            image = it.image,
            weeks = it.weeks,
            star = it.start

        )


    }

}

fun fromInternetToCourseDetailEntity(course: CourseDetail): CoursesDetailEntity{

    return CoursesDetailEntity(
            id=course.id,
            title = course.title,
            previewDescription = course.previewDescription,
            image = course.image,
            weeks = course.weeks,
            tuition= course.tuition,
           minimumSkill= course.minimumSkill,
            scholarshipAvailable =true,
            modality = course.modality,
            star = course.start

        )


    }












