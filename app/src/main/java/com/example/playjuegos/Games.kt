package com.example.playjuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Games : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.games)

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        val checkBok1 = findViewById<CheckBox>(R.id.checkBox)
        val checkBok2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBok3 = findViewById<CheckBox>(R.id.checkBox3)
        val checkBok4 = findViewById<CheckBox>(R.id.checkBox4)
        val checkBok5 = findViewById<CheckBox>(R.id.checkBox5)
        val checkBok6 = findViewById<CheckBox>(R.id.checkBox6)
        val checkBok7 = findViewById<CheckBox>(R.id.checkBox7)
        val arrayCheck = arrayOf(checkBok1,checkBok2,checkBok3,checkBok4,checkBok5,checkBok6,checkBok7)

        fab.setOnClickListener {
            val juegos = ArrayList<String>(0)
            var mensaje = "Has elegido "

            for (i in 0..6){
                if (arrayCheck[i].isChecked)
                    juegos.add(arrayCheck[i].text.toString())
            }

            if (juegos.size == 0){
                Toast.makeText(applicationContext,"No has seleccionado ninguna opción", Toast.LENGTH_LONG).show()
            }else if (juegos.size == 1){
                Toast.makeText(applicationContext,"Has elegido ${juegos[0]}.", Toast.LENGTH_LONG).show()
            }else{
                for (i in 1..juegos.size){
                    mensaje += when (i) {
                        juegos.size -> {
                            "${juegos[i-1]}."
                        }
                        juegos.size-1 -> {
                            "${juegos[i-1]} y "
                        }
                        else -> {
                            "${juegos[i-1]}, "
                        }
                    }
                }
                Toast.makeText(applicationContext,mensaje, Toast.LENGTH_LONG).show()
            }
        }
    }


}