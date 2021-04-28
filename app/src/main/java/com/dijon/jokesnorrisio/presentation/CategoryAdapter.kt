package com.dijon.jokesnorrisio.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dijon.jokesnorrisio.databinding.ItemCategoryBinding

class CategoryAdapter(
    private val categories: List<String>,
    private val onItenClickListener: (categoria: String) -> Unit
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        val itemCategoryBinding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(itemCategoryBinding, onItenClickListener)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindView(categories[position])
    }

    override fun getItemCount() = categories.size

    class CategoryViewHolder(
        itemCategoryBinding: ItemCategoryBinding,
        private val onItemClickListener: (categoria : String) -> Unit
    ) :
        RecyclerView.ViewHolder(itemCategoryBinding.root) {
        var category = itemCategoryBinding.tvCategory

        fun bindView(category_: String) {
            this.category.text = category_

            itemView.setOnClickListener {
                onItemClickListener.invoke(category_)
            }
        }
    }
}

