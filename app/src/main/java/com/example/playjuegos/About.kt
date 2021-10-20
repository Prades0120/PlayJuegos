package com.example.playjuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.CheckBox
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton3)

        val items = ArrayList<Tarjeta>()
        items.add(Tarjeta(R.mipmap.ic_whale_foreground, R.string.maria_mata, R.string.year2014))
        items.add(Tarjeta(R.mipmap.ic_flowers_foreground, R.string.antonio_sanz, R.string.year1890))
        items.add(Tarjeta(R.mipmap.ic_forest_foreground, R.string.carlos, R.string.year965))
        items.add(Tarjeta(R.mipmap.ic_cannon_foreground, R.string.berta, R.string.year945))
        items.add(Tarjeta(R.mipmap.ic_river_foreground, R.string.hector_campos, R.string.year879))
        items.add(Tarjeta(R.mipmap.ic_plains_foreground, R.string.ismael, R.string.year678))
        items.add(Tarjeta(R.mipmap.ic_tucan_foreground, R.string.rodrigo, R.string.year514))
        items.add(Tarjeta(R.mipmap.ic_turtle_foreground, R.string.alex, R.string.year398))

        val recView = findViewById<RecyclerView>(R.id.recyclerView2)

        recView.setHasFixedSize(true)

        val adaptador = CardAdapter2(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adaptador.onClick = {
            Toast.makeText(this, ""+ resources.getString(items[recView.getChildAdapterPosition(it)].cadena1), Toast.LENGTH_LONG).show()

        }
    }
}