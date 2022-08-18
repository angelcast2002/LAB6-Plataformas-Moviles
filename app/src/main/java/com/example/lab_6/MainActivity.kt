package com.example.lab_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottomNav_bottomNavActivity)
        setCurrentFragment(FirstFragment())
        setListeners()
    }

    private fun setListeners() {
        bottomNav.setOnItemSelectedListener {
            // Dependiendo el item del menu, mostramos el fragment deseado
            when(it.itemId) {
                R.id.menu_home -> setCurrentFragment(FirstFragment())
                //R.id.menu_library -> setCurrentFragment(SecondFragment())
                //R.id.menu_search -> setCurrentFragment(ThirdFragment())
            }
            true
        }
    }

    /**
     * Función que reemplaza el fragment actual. No usamos backstack porque
     * para este tipo de navegación, no es el comportamiento esperado.
     */
    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer_mainActivity, fragment)
        }
    }
}