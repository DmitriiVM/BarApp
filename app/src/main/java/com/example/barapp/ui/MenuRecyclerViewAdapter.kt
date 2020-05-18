package com.example.barapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barapp.R
import com.example.barapp.models.MenuItem
import kotlinx.android.synthetic.main.menu_item.view.*

class MenuRecyclerViewAdapter(): RecyclerView.Adapter<MenuRecyclerViewAdapter.ViewHolder>() {

    private var menu: List<MenuItem> = arrayListOf()
    private var quantity = 0

    fun setMenu(menu: List<MenuItem>){
        this.menu = menu + menu + menu + menu
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.menu_item_2, parent, false))

    override fun getItemCount(): Int = menu.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(menu[position])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private var quantity = 0

        fun onBind(menuItem: MenuItem) {
            with(itemView){
                textViewName.text = menuItem.name
                textViewPrice.text = "${menuItem.price} р."


                buttonPlus.setOnClickListener {
                    textViewQuantity.text =  (++quantity).toString()
                }
                buttonMinus.setOnClickListener {
                    textViewQuantity.text =  (--quantity).toString()
                }
            }
        }

    }
}