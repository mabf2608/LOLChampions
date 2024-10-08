package com.turing.alan.cpifp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.turing.alan.cpifp.R
import com.turing.alan.cpifp.data.Champion
import coil.load

class ChampDetailFragment : Fragment() {
    private lateinit var champion : Champion

    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup,
        savedInstanceState: Bundle?
    ):View{
        val view = inflater.inflate(R.layout.fragment_champ_detail, container, false)

        val imageView : ImageView = view.findViewById(R.id.champImage)
        val nameView : TextView = view.findViewById(R.id.champName)
        val titleView : TextView = view.findViewById(R.id.champTitle)
        val loreView : TextView = view.findViewById(R.id.champLore)

        imageView.load(champion.imageUrl)
        nameView.text = champion.name
        titleView.text = champion.title
        loreView.text = champion.lore

        return view
    }
    fun setChamp(champion: Champion) {
        this.champion = champion
    }
}