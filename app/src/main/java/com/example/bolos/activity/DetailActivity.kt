package com.example.bolos.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.bolos.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // captura as views
        val img     = findViewById<ImageView>(R.id.pedidoImage)
        val title   = findViewById<TextView>(R.id.pedidoTitle)
        val desc    = findViewById<TextView>(R.id.pedidoDesc)
        val priceTv = findViewById<TextView>(R.id.textView19)
        // se quiser rating, pode usar seu ImageView de estrela e TextView de rating

        // lê extras
        val t = intent.getStringExtra("EXTRA_TITLE") ?: ""
        val d = intent.getStringExtra("EXTRA_DESC")  ?: ""
        val p = intent.getDoubleExtra("EXTRA_PRICE", 0.0)
        val picUrl = intent.getStringExtra("EXTRA_PIC") ?: ""

        // preenche as views
        title.text    = t
        desc.text     = d
        priceTv.text  = "R$ ${"%.2f".format(p)}"
        // carrega imagem
        val resName = picUrl.removePrefix("@drawable/")
        val resId = this.resources.getIdentifier(resName, "drawable", packageName)
        if (resId != 0) img.setImageResource(resId)

        // Back button
        findViewById<ImageView>(R.id.imageView8).setOnClickListener {
            finish()
        }
        findViewById<LinearLayout>(R.id.backclick).apply {
            isClickable = true
            setOnClickListener { finish() }
        }
        hideSystemUI()
    }

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

}
