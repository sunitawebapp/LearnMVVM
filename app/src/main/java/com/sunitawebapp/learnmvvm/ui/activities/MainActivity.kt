package com.sunitawebapp.learnmvvm.ui.activities


import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.sunitawebapp.learnmvvm.R
import com.sunitawebapp.learnmvvm.databinding.ActivityMainBinding


class MainActivity :  BaseActivity() {
    private lateinit var binding: ActivityMainBinding
     lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController = super.getNavController(R.id.main_nav_host)


    }

    override fun getLayoutResource(): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }
}
