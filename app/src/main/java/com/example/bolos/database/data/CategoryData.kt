package com.example.bolos.database.data

import com.example.bolos.database.model.CategoryModel

class CategoryData {
    companion object {
        private val categories: ArrayList<CategoryModel> = ArrayList()

        private fun loadCategory() {
            categories.add(CategoryModel("Bolo", 0))
            categories.add(CategoryModel("Macarron", 1))
            categories.add(CategoryModel("Tiramisu", 2))
            categories.add(CategoryModel("Torta", 3))
            categories.add(CategoryModel("Outros", 4))
        }

        fun getCategory() : ArrayList<CategoryModel> {
            if (categories.isEmpty()) {
                loadCategory()
            }
            return categories;
        }
    }
}