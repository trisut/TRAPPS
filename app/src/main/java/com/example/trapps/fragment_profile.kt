package com.example.trapps

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class fragment_profile : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val imageView: ImageView = view.findViewById(R.id.imageView)
        val imageView5: ImageView = view.findViewById(R.id.imageView5)
        val imageView6: ImageView = view.findViewById(R.id.imageView6)
        val imageView7: ImageView = view.findViewById(R.id.imageView7)
        val imageView8: ImageView = view.findViewById(R.id.imageView8)

        imageView.setOnClickListener {
            openWebPage("https://www.facebook.com/adrianmaulana.adrianmaulana.50159")
        }

        imageView5.setOnClickListener {
            openWebPage("https://www.instagram.com/adriannmr/?hl=en")
        }

        imageView6.setOnClickListener {
            openWebPage("https://github.com/adriannmr")
        }
        imageView7.setOnClickListener {
            openWebPage("https://www.tiktok.com/@adriannmr?_t=8myIB4Xay3j&_r=1")
        }
        imageView8.setOnClickListener {
            openWebPage("https://www.google.com/maps/place/6°51'29.9\"S+107°30'56.3\"E/@-6.8582973,107.513073,17z/data=!3m1!4b1!4m4!3m3!8m2!3d-6.8582973!4d107.5156479?hl=en&entry=ttu")
        }

        return view
    }

    private fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }
}