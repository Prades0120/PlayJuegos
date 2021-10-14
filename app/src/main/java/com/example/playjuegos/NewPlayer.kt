package com.example.playjuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class NewPlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_player)

        val telefonos = arrayOf ("Telefono1", "Telefono2", "Telefono3", "Telefono4","Telefono5")

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, telefonos)

        val listaTelefonos = findViewById<Spinner>(R.id.spinner)
        listaTelefonos.adapter = adaptador
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        listaTelefonos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val telefono = findViewById<TextView>(R.id.editTextNumber)
                if (parent != null) {
                    telefono.text = parent.getItemAtPosition(position).toString()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}