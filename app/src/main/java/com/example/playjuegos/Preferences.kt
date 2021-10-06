package com.example.playjuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Preferences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.preferences)

        val rGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        val sb = findViewById<SeekBar>(R.id.seekBar)
        val rb = findViewById<RatingBar>(R.id.ratingBar)
        var option: String? = null

        sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                rb.rating = progress.toFloat()/2
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }

        })

        rb.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { _, rating, _ ->
            sb.progress = (rating*2).toInt()
        }

        rGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {

            override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
                val checkedRadioButton = rGroup.findViewById<RadioButton>(checkedId)
                option = checkedRadioButton.text as String
            }
        })

        fab.setOnClickListener{
            if (option==null){
                Toast.makeText(applicationContext,"No has pulsado ninguna opción", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext,"$option Puntuación: ${rb.rating}", Toast.LENGTH_LONG).show()
            }
        }
    }
}