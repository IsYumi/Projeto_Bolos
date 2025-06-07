package com.example.bolos.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.bolos.R
import com.example.bolos.databinding.ActivityMainBinding

class PerfilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        view = binding.root
        setContentView(R.layout.viewuser)
        hideSystemUI()
        findViewById<LinearLayout>(R.id.explorebutton).apply {
            isClickable = true
            setOnClickListener {
                loadMain()
            }
        }
        findViewById<AppCompatButton>(R.id.aboutusbutton).apply {
            isClickable = true
            setOnClickListener {
                loadAboutUs()
            }
        }
    }

    private fun loadMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun loadAboutUs() {
        val intent = Intent(this, AboutUsActivity::class.java)
        startActivity(intent)
    }

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}