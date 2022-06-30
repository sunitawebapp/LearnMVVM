package com.sunitawebapp.learnmvvm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.sunitawebapp.learnmvvm.Models.DetailsLists
import com.sunitawebapp.learnmvvm.R
import com.sunitawebapp.learnmvvm.adapter.DetailsAdapter
import com.sunitawebapp.learnmvvm.databinding.FragmentHomeBinding
import com.sunitawebapp.learnmvvm.databinding.FragmentLoginBinding
import com.sunitawebapp.learnmvvm.utils.DataLoad
import com.sunitawebapp.learnmvvm.viewmodel.HomeViewModel


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var rvDetails : RecyclerView
    var detailslist : MutableList<DetailsLists> =ArrayList();
     val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.apply {
            return root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        homeViewModel.getDetailsList()
        homeViewModel.detailsListslivedata.observe(viewLifecycleOwner){
            it
             var detailsAdap = DetailsAdapter(detailslist)
              rvDetails.adapter=detailsAdap
        }
       // var detailsAdap =DetailsAdapter(detailslist,this)
      //  rvDetails.adapter=detailsAdap
     //   detailsAdap.notifyDataSetChanged()
    }

}
