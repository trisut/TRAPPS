package com.example.trapps

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpalshActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)

        Handler().postDelayed({
            // Cek apakah walkthrough sudah pernah ditampilkan
            val sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            val isFirstRun = sharedPreferences.getBoolean("isFirstRun", true)

            if (isFirstRun) {
                // Tampilkan WalkthroughActivity jika ini adalah pertama kali menjalankan aplikasi
                startActivity(Intent(this, WalkthroughActivity::class.java))

                // Set isFirstRun menjadi false
                sharedPreferences.edit().putBoolean("isFirstRun", false).apply()
            } else {
                // Tampilkan MainActivity jika walkthrough sudah pernah ditampilkan
                startActivity(Intent(this, MainActivity::class.java))
            }

            finish()
        }, 3000) // Lama waktu splash screen ditampilkan (2 detik)
    }
}
