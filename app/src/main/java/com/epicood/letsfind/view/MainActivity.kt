package com.epicood.letsfind.view

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.epicood.letsfind.R
import com.epicood.letsfind.getAndroidID
import com.epicood.letsfind.model.Rating
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        var database=FirebaseDatabase.getInstance().reference
//
//        database.setValue("aaaaaaaaaaaa")





        supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.toolBarBackground)))

        navController = findNavController(R.id.fragment)
        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.baseFragment,
                R.id.resultFragment,
//            R.id.ratingFragment,
//            R.id.profilFragment,
            )
        )

        bottomBar.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.quizFragment -> bottomBar.visibility = View.GONE
                R.id.ratingFragment -> bottomBar.visibility = View.GONE
                R.id.profilFragment -> bottomBar.visibility = View.GONE
                R.id.resultFragment -> bottomBar.visibility = View.GONE
                else -> bottomBar.visibility = View.VISIBLE
            }
        }


     var mDatabase = FirebaseDatabase.getInstance().reference
        if (mDatabase != null) {
            val androidID = getAndroidID(applicationContext)
            val rating = Rating("usernameFB".toString(), "0")
            mDatabase.child(getAndroidID(applicationContext)).setValue(Rating("Aslan", "100"))
            Log.i("data", "success");
        } else {
            Log.i("data", "error");
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()

    }


}