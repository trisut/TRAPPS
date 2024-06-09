package com.example.trapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class fragment_music : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_music, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewMusic)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MusicAdapter(requireContext(), getMusicData())

        return view
    }

    private fun getMusicData(): List<Quadruple<Int, String, String, String>> {
        return listOf(
            Quadruple(R.drawable.dw,"https://open.spotify.com/track/49CPjgPScI29D1yqSmHFgK","Sandiwara Semu", "rumah sakit"),
            Quadruple(R.drawable.dw, "https://open.spotify.com/track/5lr9fSb6BKR7rkD2JNITg2?si=718436ab72c64998", "Duniawi", "rumah sakit"),
            Quadruple(R.drawable.ps, "https://open.spotify.com/track/3EXh4IzbdHQtf3pL2DCOaS?si=61e6ff3f42d94ef3", "Panasea", "rumah sakit"),
            Quadruple(R.drawable.dw, "https://open.spotify.com/track/7eq7Q23nVvIcroCRzzkyNR?si=6cb5df9cc86941e2", "Apa Yang Tak Bisa", "rumah sakit"),
        )
    }
}