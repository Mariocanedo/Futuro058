package com.example.futuro058

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.casoprueba.databinding.FragmentFirstBinding
import com.example.futuro058.ViewModel.CoursesViewModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

 private lateinit var  mBinding : FragmentFirstBinding
 private val mViewModel : CoursesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentFirstBinding.inflate(inflater, container, false)
        return mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // DEBEMOS INTANCIAR ADAPTER

        val adapter = CoursesAdapter()
        mBinding.recyclerView.adapter= adapter
        mBinding.recyclerView.layoutManager= LinearLayoutManager(context)
        mViewModel.getCourseList().observe(viewLifecycleOwner, Observer {

            it?.let {

                adapter.update(it)
            }

        })



    }

    override fun onDestroyView() {
        super.onDestroyView()
        //mBinding = null
    }
}