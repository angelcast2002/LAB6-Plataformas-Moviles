package com.example.lab_6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.commit

// TODO: Rename parameter arguments, choose names that match
class ThirdFragment : Fragment(R.layout.fragment_third) {
    private lateinit var plusBottom : ImageButton
    private var count = 0
    private lateinit var likedSongs : TextView
    private val Song = " songs"
    private lateinit var mensaje : String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plusBottom = view.findViewById(R.id.ic_plus_third_frag)
        likedSongs = view.findViewById(R.id.contador_third_frag)
        setListeners()
    }

    override fun onResume() {
        super.onResume()
        mensaje = count.toString() + Song
        likedSongs.text = mensaje
    }

    private fun setListeners() {
        plusBottom.setOnClickListener {
            count++
            mensaje = count.toString() + Song
            likedSongs.text = mensaje
        }
    }
}