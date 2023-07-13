package com.example.futuro058

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.casoprueba.databinding.CoursesListBinding
import com.example.futuro058.Modelo.local.entities.CoursesEntity


class CoursesAdapter : RecyclerView.Adapter<CoursesAdapter.CoursesVH>() {

private var listCourses = listOf<CoursesEntity>()
    private val SelectedCourse = MutableLiveData<CoursesEntity>()



     fun update(list:List<CoursesEntity>){
         listCourses= list
      notifyDataSetChanged()
     }


    // FUNCION PARA SELECCIONAR

    fun selectedCourse(): LiveData<CoursesEntity> = SelectedCourse



    inner class  CoursesVH(private val mBinding:  CoursesListBinding):
            RecyclerView.ViewHolder(mBinding.root), View.OnClickListener{

                fun bind(course: CoursesEntity){
                    Glide.with(mBinding.ivLogo).load(course.image).centerCrop().into(mBinding.ivLogo)

                    mBinding.tvname.text = course.title
                    mBinding.tvdescription.text = course.previewDescription
                    mBinding.tvduration.text = "duración: " + course.weeks.toString() + " Semanas"
                    mBinding.tvstart.text = "Inicio: " + course.star
                    itemView.setOnClickListener(this)

                }
            override  fun onClick(v: View){

                SelectedCourse.value= listCourses[adapterPosition]
            }

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesVH {
      return CoursesVH(CoursesListBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(holder: CoursesVH, position: Int) {
        val course = listCourses[position]
        holder.bind(course)
    }


    override fun getItemCount()=
               listCourses.size
    }




