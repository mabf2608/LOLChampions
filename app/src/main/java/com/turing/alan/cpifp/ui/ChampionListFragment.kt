package com.turing.alan.cpifp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.turing.alan.cpifp.data.ChampionsRepository
import com.turing.alan.cpifp.databinding.FragmentChampionListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.turing.alan.cpifp.data.Champion

@AndroidEntryPoint
class ChampionListFragment : Fragment() {

    @Inject
    lateinit var championsRepository: ChampionsRepository // Inyectamos el repositorio

    private var _binding: FragmentChampionListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChampionListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val champions = championsRepository.getChampions() // Obtener lista de campeones
        val adapter = ChampAdapter(champions) { champion ->
            // Manejar clic en un campeón
            navigateToDetail(champion)
        }

        binding.recyclerViewChamps.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewChamps.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToDetail(champion: Champion) {
        // Implementar la navegación
    }
}
