package com.example.playjuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomappbar.BottomAppBar

class Ajustes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ajustes)

        val bottomAppBar = findViewById<BottomAppBar>(R.id.bottom_appbar)
        bottomAppBar.replaceMenu(R.menu.menu_main)
    }
}