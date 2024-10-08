package com.turing.alan.cpifp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.turing.alan.cpifp.R
import com.turing.alan.cpifp.data.InMemoryChampionsRepository
import com.turing.alan.cpifp.data.Champion


class ChampListFragment : Fragment() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var champAdapter: ChampAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container:ViewGroup?,
        savedInstanceState:Bundle?
    ): View{
        val view = inflater.inflate(R.layout.activity_main, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewChamps)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val champions = InMemoryChampionsRepository.getInstance().getChampions()

        champAdapter = ChampAdapter(champions) {champion -> onChampSelected(champion)}
        recyclerView.adapter = champAdapter

        return view

    }

    private fun onChampSelected(champion:Champion){
        val detailFragment = ChampDetailFragment()
        detailFragment.setChamp(champion)

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, detailFragment)
            .addToBackStack(null)
            .commit()
    }
}