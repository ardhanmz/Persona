package com.zesthra.persona.ui.home

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.zesthra.persona.R
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        navController = Navigation.findNavController(this, R.id.nav_home)

        /*workaround for https://issuetracker.google.com/issues/142847973*/
        navController = getNavController()
        NavigationUI.setupWithNavController(navigation, navController)

//        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }
    override fun onBackPressed() {
        when(Navigation.findNavController(this, R.id.nav_home).currentDestination?.id) {
            R.id.navigation_home -> {
                AlertDialog.Builder(this).setMessage("Hello").setPositiveButton(
                    "Ok",
                    { dialogInterface, i ->
                        finish()
                    }).show()
            }
            else -> {
                super.onBackPressed()
            }
        }
    }

    /*workaround for https://issuetracker.google.com/issues/142847973*/
    private fun getNavController(): NavController {
        val fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.nav_home)
        check(fragment is NavHostFragment) {
            ("Activity " + this
                    + " does not have a NavHostFragment")
        }
        return (fragment as NavHostFragment?)!!.navController
    }
}