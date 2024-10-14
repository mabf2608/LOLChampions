// ChampionListFragment.kt
package com.turing.alan.cpifp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.turing.alan.cpifp.R
import com.turing.alan.cpifp.data.InMemoryChampionsRepository
import com.turing.alan.cpifp.data.Champion

class ChampionListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_champion_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewChamps)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ChampAdapter(InMemoryChampionsRepository.getInstance().getChampions()) {
            navigateToDetail(it)
        }

        return view
    }

    private fun navigateToDetail(champion: Champion) {
        val fragment = ChampionDetailFragment.newInstance(champion.id)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
