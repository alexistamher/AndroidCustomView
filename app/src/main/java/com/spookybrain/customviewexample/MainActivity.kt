package com.spookybrain.customviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // toolbar was the id which defined on xml file
        val coolToolbar: CustomToolbar = findViewById(R.id.toolbar)
        coolToolbar.setOnMenuPressedListener {
            // show a drawer navigation or another action
        }
        coolToolbar.setOnGoBackPressedListener {
            // close the current activity
        }
        coolToolbar.setOnOkPressedListener {
            // save all changes
        }
    }
}