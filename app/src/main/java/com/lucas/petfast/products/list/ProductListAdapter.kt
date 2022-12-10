package com.lucas.petfast.products.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucas.petfast.R
import com.lucas.petfast.databinding.ProductListBinding
import com.lucas.petfast.products.remote.ProductsResponse

class ProductListAdapter : RecyclerView.Adapter<TransactionViewHolder>() {

    private val listItem: MutableList<ProductsResponse> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item = listItem[position]
        holder.bind(item)
    }

    fun addList(list: List<ProductsResponse>) {
        listItem.addAll(list)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
}

class TransactionViewHolder(
    private val binding: ProductListBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(productsResponse: ProductsResponse) {
        productsResponse.name.also { binding.tvProductName.text = it }
        productsResponse.description.also { binding.tvDescription.text = it }
        "R$ ${2.formatsNew(productsResponse.value)}".also { binding.tvValue.text = it }

        when (productsResponse.typeProduct) {
            "PRODUCT" -> binding.icon.setImageResource(R.drawable.ic_baseline_store_24)
            "SERVICE" -> binding.icon.setImageResource(R.drawable.ic_baseline_pets_24)
        }
    }

    private fun Int.formatsNew(input: Double) = String.format("%.${this}f", input)
}