package com.example.bolos.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bolos.R
import com.example.bolos.adapters.ItemAdapter
import com.example.bolos.database.adapter.CategoryAdapter
import com.example.bolos.database.data.CategoryData
import com.example.bolos.database.data.ItemData
import com.example.bolos.database.model.ItemModel
import com.example.bolos.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        view = binding.root
        setContentView(R.layout.activity_main)
        hideSystemUI()
        loadCategory()
        loadItem()
        findViewById<LinearLayout>(R.id.perfilbutton).apply {
            isClickable = true
            setOnClickListener {
                loadPerfil()
            }
        }
    }

    private fun loadPerfil() {
        val intent = Intent(this, PerfilActivity::class.java)
        startActivity(intent)
    }

    private fun loadCategory() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCat)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = CategoryAdapter(CategoryData.getCategory()) { category ->
            //TODO NOT IMPLEMENTED
        }
    }

    private fun loadItem() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewPopular)
        val items: ArrayList<ItemModel> = ItemData.getCategory()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(items)
    }

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}