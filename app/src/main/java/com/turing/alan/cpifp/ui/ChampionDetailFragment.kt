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
import com.turing.alan.cpifp.data.ChampionsRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChampionDetailFragment : Fragment() {

    @Inject
    lateinit var championsRepository: ChampionsRepository // Inyectamos el repositorio

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

        championId?.let { id ->
            val champion = championsRepository.getChampions().find { champ -> champ.id == id }
            champion?.let {
                view.findViewById<ImageView>(R.id.champDetailImage).load(it.imageUrl)
                view.findViewById<TextView>(R.id.champDetailName).text = it.name
                view.findViewById<TextView>(R.id.champDetailTitle).text = it.title
                view.findViewById<TextView>(R.id.champDetailLore).text = it.lore
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

