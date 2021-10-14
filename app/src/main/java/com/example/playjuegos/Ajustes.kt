package com.example.playjuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class Ajustes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ajustes)

        val bottomAppBar = findViewById<BottomAppBar>(R.id.bottomAppBar)
        bottomAppBar.replaceMenu(R.menu.menu_main)

        val items = ArrayList<Generos>()
        items.add(Generos(R.string.accion))
        items.add(Generos(R.string.aventura))
        items.add(Generos(R.string.arcade))
        items.add(Generos(R.string.deportes))
        items.add(Generos(R.string.disparos))
        items.add(Generos(R.string.estrategia))
        items.add(Generos(R.string.juegos_de_mesa))
        items.add(Generos(R.string.juegos_musicales))
        items.add(Generos(R.string.lucha))
        items.add(Generos(R.string.puzzles))
        items.add(Generos(R.string.simulacion))

        val recView = findViewById<RecyclerView>(R.id.recyclerView)

        recView.setHasFixedSize(true)

        val adaptador = CardsAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adaptador.onClick = {
            Toast.makeText(this, ""+ recView.getChildAdapterPosition(it), Toast.LENGTH_LONG).show()
        }
    }
}