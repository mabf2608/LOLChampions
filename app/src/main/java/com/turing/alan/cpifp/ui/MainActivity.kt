package com.turing.alan.cpifp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.turing.alan.cpifp.R
import com.turing.alan.cpifp.data.InMemoryChampionsRepository

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var championAdapter: ChampAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_champ_list)

        // Inicializa el RecyclerView
        recyclerView = findViewById(R.id.recyclerViewChamps)

        // Establece un LayoutManager (en este caso, vertical)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Obtén la lista de campeones del repositorio
        val champions = InMemoryChampionsRepository.getInstance().getChampions()

        // Inicializa el Adapter con la lista de campeones
        championAdapter = ChampAdapter(champions)

        // Asigna el Adapter al RecyclerView
        recyclerView.adapter = championAdapter
    }
}