package com.example.bolos.database.data

import com.example.bolos.database.model.ItemModel

class ItemData {
    companion object {
        private val items: ArrayList<ItemModel> = ArrayList()

        private fun loadCategory() {
            items.add(ItemModel("Bolo", "Bolo simples", 42.0, 4.0, "@drawable/cake"))
            items.add(ItemModel("Tiramisu", "Tiramisu", 30.0, 4.5, "@drawable/tiramisu"))
            items.add(ItemModel("Bolos Variados", "Conjunto de diferentes fatias de bolo", 130.0, 4.6, "@drawable/pedacosbolo"))
            items.add(ItemModel("Macarron", "Conjunto de Macarrons coloridos", 24.0, 3.0, "@drawable/macarrons"))
        }

        fun getCategory() : ArrayList<ItemModel> {
            if (items.isEmpty()) {
                loadCategory()
            }
            return items;
        }
    }

}