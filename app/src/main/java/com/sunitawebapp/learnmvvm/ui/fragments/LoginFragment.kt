package com.sunitawebapp.learnmvvm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sunitawebapp.learnmvvm.Models.UserDetailsList
import com.sunitawebapp.learnmvvm.R
import com.sunitawebapp.learnmvvm.databinding.FragmentLoginBinding
import com.sunitawebapp.learnmvvm.viewmodel.LoginViewModel
import org.json.JSONObject


class LoginFragment : Fragment() ,View.OnClickListener{
     val loginViewModel: LoginViewModel by viewModels()
    lateinit var binding: FragmentLoginBinding
 var userDetailsList: MutableList<UserDetailsList> =ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.apply {
            return root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setOnClickListener(view)
        loginViewModel.getApiCallForUserDetails(requireContext())

        loginViewModel.userDetailsLiveData.observe(viewLifecycleOwner){
            var jsonObject=JSONObject(it)

         binding.etnUsername.setText( jsonObject.getString("UserName"))
         binding.etnPassword.setText( jsonObject.getString("Password"))

        }
        super.onViewCreated(view, savedInstanceState)
    }

    fun setOnClickListener(view: View){
        binding.tvLogin.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.tvLogin->{
               findNavController().navigate(R.id.homeFragment)
            }
        }
    }
}
