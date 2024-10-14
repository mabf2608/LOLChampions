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

class ChampAdapter (val champions:List<Champion>): RecyclerView.Adapter<ChampAdapter.ChampionViewHolder>(){


    class ChampionViewHolder(view:View):RecyclerView.ViewHolder(view){
        val name:TextView=view.findViewById(R.id.champName)
        val title:TextView=view.findViewById(R.id.champTitle)
        val lore:TextView=view.findViewById(R.id.champLore)
        val image:ImageView=view.findViewById(R.id.champImage)
    }

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):ChampionViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.champion,parent,false)
        return ChampionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) {
        val champ = champions[position]
        holder.name.text = champ.name
        holder.title.text = champ.title
        holder.lore.text = champ.lore
        holder.image.load(champ.imageUrl)
    }
    override fun getItemCount(): Int {
        return champions.size
    }
}