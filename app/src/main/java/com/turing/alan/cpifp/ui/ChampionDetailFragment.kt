package com.turing.alan.cpifp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.load
import com.turing.alan.cpifp.R
import com.turing.alan.cpifp.data.InMemoryChampionsRepository

class ChampionDetailFragment : Fragment() {

    private var championId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        championId = arguments?.getInt(ARG_CHAMPION_ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_champion_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Usamos findViewById para enlazar las vistas
        val champDetailImage: ImageView = view.findViewById(R.id.champDetailImage)
        val champDetailName: TextView = view.findViewById(R.id.champDetailName)
        val champDetailTitle: TextView = view.findViewById(R.id.champDetailTitle)
        val champDetailLore: TextView = view.findViewById(R.id.champDetailLore)

        championId?.let { id ->
            val champion = InMemoryChampionsRepository.getInstance().getChampions().find { champ -> champ.id == id }
            champion?.let {
                champDetailImage.load(it.imageUrl)
                champDetailName.text = it.name
                champDetailTitle.text = it.title
                champDetailLore.text = it.lore
            }
        }
    }

    companion object {
        private const val ARG_CHAMPION_ID = "champion_id"

        fun newInstance(championId: Int) = ChampionDetailFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_CHAMPION_ID, championId)
            }
        }
    }
}

