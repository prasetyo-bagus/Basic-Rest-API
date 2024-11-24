package com.bytyo.harrypotter

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bytyo.harrypotter.model.Characters
import com.bytyo.harrypotter.model.Houses
import com.bytyo.harrypotter.api.RetrofitPotterAPI
import com.bytyo.harrypotter.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_book, R.id.navigation_character, R.id.navigation_house, R.id.navigation_spell
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        lifecycleScope.launch {
            val listOfCharacter: List<Characters> = RetrofitPotterAPI.potterAPIService.getCharacters("en")

            val listOfHouse: List<Houses> = RetrofitPotterAPI.potterAPIService.getHouses("en")

            for (character in listOfCharacter) {
                Log.d("restchar", character.fullName)
            }
            for (house in listOfHouse) {
                Log.d("resthouse", house.house)
            }

        }
    }
}