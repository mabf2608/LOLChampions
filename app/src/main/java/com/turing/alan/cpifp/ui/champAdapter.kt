package com.turing.alan.cpifp.ui

import coil.load
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.turing.alan.cpifp.R
import com.turing.alan.cpifp.data.Champion

class ChampAdapter(
    private val champions: List<Champion>,           // Lista de campeones
    private val onItemClick: (Champion) -> Unit      // Callback para clic en un campeón
) : RecyclerView.Adapter<ChampAdapter.ChampionViewHolder>() {

    class ChampionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.champName)
        val title: TextView = view.findViewById(R.id.champTitle)
        val image: ImageView = view.findViewById(R.id.champImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.champion, parent, false)
        return ChampionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) {
        val champ = champions[position]
        holder.name.text = champ.name
        holder.title.text = champ.title
        holder.image.load(champ.imageUrl)

        // Manejar clic en el item del campeón
        holder.itemView.setOnClickListener {
            onItemClick(champ)  // Llamar al callback con el campeón clicado
        }
    }

    override fun getItemCount(): Int {
        return champions.size
    }
}
