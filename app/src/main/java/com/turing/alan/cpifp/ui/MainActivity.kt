package com.turing.alan.cpifp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.turing.alan.cpifp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ChampionListFragment())
                .commit()
        }
    }
}
