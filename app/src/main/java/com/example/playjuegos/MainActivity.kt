package com.example.playjuegos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val jugador = findViewById<Button>(R.id.button2)
        jugador.setOnClickListener {lanzarNewPlayer()}

        val preferences = findViewById<Button>(R.id.button3)
        preferences.setOnClickListener {lanzarPreferences()}

        val jugar = findViewById<Button>(R.id.button1)
        jugar.setOnClickListener {lanzarGames()}

        val about = findViewById<Button>(R.id.button4)
        about.setOnClickListener {lanzarAbout()}
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.app_bar_search) {
            Toast.makeText(this,"Busqueda",Toast.LENGTH_LONG).show()
            return true
        }else if(id == R.id.action_settings){
            lanzarAjustes()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun lanzarNewPlayer() {
        val i = Intent(this,NewPlayer::class.java)
        startActivity(i)
    }

    private fun lanzarPreferences() {
        val i = Intent(this, Preferences::class.java)
        startActivity(i)
    }

    private fun lanzarGames() {
        val i = Intent(this, Games::class.java)
        startActivity(i)
    }

    private fun lanzarAjustes() {
        val i = Intent(this, Ajustes::class.java)
        startActivity(i)
    }

    private fun lanzarAbout() {
        val i = Intent(this, About::class.java)
        startActivity(i)
    }
}