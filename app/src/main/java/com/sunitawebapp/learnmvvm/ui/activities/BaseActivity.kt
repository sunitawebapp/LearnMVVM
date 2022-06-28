package com.sunitawebapp.learnmvvm.ui.activities

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.sunitawebapp.learnmvvm.R


abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
    }

    protected fun setActivityBehindStatusBar(){
        //window.statusBarColor = ResourcesCompat.getColor(resources, R.color.transparentStatusBar,null)
        /*setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
        window.statusBarColor = Color.TRANSPARENT*/

        /*window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        )*/
    }

    private fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
        val win: Window = activity.window

        val winParams: WindowManager.LayoutParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

    protected fun setupToolbar(toolBar: Toolbar){
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        //toolBar.setPadding(0, getStatusBarHeight(), 0, 0);
    }

    protected fun getNavController(navHost: Int) : NavController {
        val navHostFragment =
            supportFragmentManager.findFragmentById(navHost) as NavHostFragment
        return navHostFragment.navController
    }

    protected fun appbarConfig(navController: NavController, toolbar: Toolbar, homeFragmentID: Int?, drawerLayout: DrawerLayout?){
        val topLevelDestinations: MutableSet<Int> = HashSet()
        topLevelDestinations.add(R.id.splashFragment)
        val appBarConfiguration =
            AppBarConfiguration.Builder(topLevelDestinations).setOpenableLayout(drawerLayout)
                .build()
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    // A method to find height of the status bar
    private fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    protected abstract fun getLayoutResource() : View
}
