package com.example.intothebreachmultimedia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
class MechasAdapter(
    private var mechaList: List<Mecha>,
    private val onItemClick: (Mecha) -> Unit
) : RecyclerView.Adapter<MechasAdapter.MechaViewHolder>() {

    // ViewHolder interno que gestiona cada elemento de la lista
    inner class MechaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.TxtMechName)
        val imgMech: LinearLayout = view.findViewById(R.id.LayoutImg)
        fun bind(mecha: Mecha) {
            nameTextView.text = mecha.nameMecha
            imgMech.setBackgroundResource(mecha.imgMecha)
            // Evento al hacer clic en el elemento
            itemView.setOnClickListener {
                onItemClick(mecha)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MechaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mecha, parent, false)
        return MechaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MechaViewHolder, position: Int) {
        val mecha = mechaList[position]
        holder.bind(mecha)
    }

    override fun getItemCount(): Int {
        return mechaList.size
    }
}