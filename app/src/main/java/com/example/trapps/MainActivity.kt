package com.example.trapps

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity() : AppCompatActivity(), Parcelable {

    private lateinit var bottomNavigationView: BottomNavigationView

    constructor(parcel: Parcel) : this() {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.bottom_home -> {
                    replaceFragment(fragment_home())
                    true
                }

                R.id.bottom_daily -> {
                    replaceFragment(fragment_daily())
                    true
                }

                R.id.bottom_profile -> {
                    replaceFragment(fragment_profile())
                    true
                }

                R.id.bottom_gallery -> {
                    replaceFragment(fragment_gallery())
                    true
                }

                R.id.bottom_music -> {
                    replaceFragment(fragment_music())
                    true
                }
                else -> false
            }
        }
        replaceFragment(fragment_home())
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit()
    }
}