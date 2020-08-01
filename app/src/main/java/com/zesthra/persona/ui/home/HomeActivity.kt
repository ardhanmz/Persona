package com.zesthra.persona.ui.home

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.zesthra.persona.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navController = Navigation.findNavController(this, R.id.nav_home)
        NavigationUI.setupWithNavController(navigation,navController)
//        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,null)
    }
    override fun onBackPressed() {
        when(Navigation.findNavController(this, R.id.nav_home).currentDestination?.id) {
            R.id.navigation_home-> {
                val dialog= AlertDialog.Builder(this).setMessage("Hello").setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i ->
                    finish()
                }).show()
            }
            else -> {
                super.onBackPressed()
            }
        }
    }
}