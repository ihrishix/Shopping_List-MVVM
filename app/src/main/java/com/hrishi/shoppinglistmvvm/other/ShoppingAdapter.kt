package com.hrishi.shoppinglistmvvm.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hrishi.shoppinglistmvvm.R
import com.hrishi.shoppinglistmvvm.data.db.entity.ShoppingItem
import com.hrishi.shoppinglistmvvm.ui.shoppingList.ShoppingViewModel

class ShoppingAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingAdapter.ShoppingItemViewHolder>() {

    inner class ShoppingItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val tv_name: TextView = holder.itemView.findViewById(R.id.tv_name)
        val tv_amount: TextView = holder.itemView.findViewById(R.id.tv_amount)
        val iv_delete: ImageView = holder.itemView.findViewById(R.id.iv_delete)
        val iv_minus: ImageView = holder.itemView.findViewById(R.id.iv_minus)
        val iv_plus: ImageView = holder.itemView.findViewById(R.id.iv_plus)

        tv_name.text = items[position].name
        tv_amount.text = items[position].count.toString()

        iv_delete.setOnClickListener {
            viewModel.delete(items[position])

            iv_plus.setOnClickListener {
                items[position].count++
                viewModel.upsert(items[position])
            }

            iv_minus.setOnClickListener {
                if (items[position].count > 0) {
                    items[position].count--
                    viewModel.upsert(items[position])
                }
            }

        }
    }

    override fun getItemCount() = items.size
}