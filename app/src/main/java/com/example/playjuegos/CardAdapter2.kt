package com.example.playjuegos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter2(private var items: ArrayList<Tarjeta>) : RecyclerView.Adapter<CardAdapter2.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit
    val checkBoxes = arrayListOf<CheckBox>()

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var texto1: TextView = itemView.findViewById(R.id.textAbout1)
        var texto2: CheckBox = itemView.findViewById(R.id.textAbout2)
        private var image: ImageView = itemView.findViewById(R.id.imageViewAbout)

        fun bindTarjeta(t: Tarjeta, onClick: (View) -> Unit) = with(itemView) {
            texto1.setText((t.cadena1))
            texto2.setText((t.cadena2))
            image.setImageResource((t.image))
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_about, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items[pos]
        viewHolder.bindTarjeta(item, onClick)
        viewHolder.texto2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (viewHolder.texto2.isChecked)
                checkBoxes.add(viewHolder.texto2)
            else
                checkBoxes.remove(viewHolder.texto2)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}