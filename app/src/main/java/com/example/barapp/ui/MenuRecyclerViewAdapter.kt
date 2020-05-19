package com.example.barapp.ui

import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.animation.doOnEnd
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.barapp.R
import com.example.barapp.extensions.dpToPx
import com.example.barapp.models.MenuItem
import kotlinx.android.synthetic.main.menu_item.view.buttonMinus
import kotlinx.android.synthetic.main.menu_item.view.buttonPlus
import kotlinx.android.synthetic.main.menu_item.view.textViewName
import kotlinx.android.synthetic.main.menu_item.view.textViewPrice
import kotlinx.android.synthetic.main.menu_item.view.textViewQuantity
import kotlinx.android.synthetic.main.menu_item_2_expandaple.view.*

class MenuRecyclerViewAdapter() : RecyclerView.Adapter<MenuRecyclerViewAdapter.MenuViewHolder>() {

//    private var menu: List<MenuItem> = arrayListOf()
    private var menu: ArrayList<MenuItem> = arrayListOf()
    private var quantity = 0
    private var expandedItem : MenuItem? = null
    private lateinit var recyclerView: RecyclerView

    fun setMenu(menu: List<MenuItem>) {
        // for test
        this.menu.addAll(menu)
        val menuList1 = mutableListOf<MenuItem>()
        menu.forEachIndexed { index, menuItem ->
            menuList1.add(menuItem.copy())
        }
        menuList1.forEach {
            it.id = it.id + 100
            it.price = it.price + 1000
        }
        this.menu.addAll(menuList1)

        val menuList2 = mutableListOf<MenuItem>()
        menu.forEachIndexed { index, menuItem ->
            menuList2.add(menuItem.copy())
        }
        menuList2.forEach {
            it.id = it.id + 1000
            it.price = it.price + 100000
        }
        this.menu.addAll(menuList2)

        val menuList3 = mutableListOf<MenuItem>()
        menu.forEachIndexed { index, menuItem ->
            menuList3.add(menuItem.copy())
        }
        menuList3.forEach {
            it.id = it.id + 10000
            it.price = it.price + 10000000
        }
        this.menu.addAll(menuList3)
        //  ------------------------

//        this.menu = menu
        notifyDataSetChanged()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder =
        MenuViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.menu_item_2_expandaple, parent, false)
        )

    override fun getItemCount(): Int = menu.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = menu[position]

        if (item == expandedItem){
            holder.itemView.expandable_container.isVisible = true
            setExpandProgress(holder, 1f)
        } else {
            holder.itemView.expandable_container.isGone = true
            setExpandProgress(holder, 0f)
        }


        holder.onBind(holder, item)




        holder.itemView.setOnClickListener {
            when (expandedItem) {
                null -> {
                    openItem(holder)
                    expandedItem = item
                }
                item -> {
                    closeItem(holder, null)
                    expandedItem = null
                }
                else -> {
                    val expandedItemPosition = menu.indexOf(expandedItem!!)
                    val previousExpandedViewHolder =
                        recyclerView.findViewHolderForAdapterPosition(expandedItemPosition) as? MenuViewHolder

                    if (previousExpandedViewHolder != null){
                        closeItem(previousExpandedViewHolder, holder)
                    } else {
                        openItem(holder)
                    }

                    expandedItem = item
                }
            }

        }
    }

    private fun openItem(holder: MenuViewHolder) {

        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.duration = 200
        animator.addUpdateListener { progress ->
            setExpandProgress(holder, progress.animatedValue as Float)
        }
        animator.doOnEnd {
            holder.itemView.expandable_container.isVisible = true
            holder.itemView.expandable_container.alpha = 0f
            holder.itemView.expandable_container.animate().alpha(1f).setDuration(200)
        }
        animator.start()
    }

    private fun closeItem(holder: MenuViewHolder, holderToOpen: MenuViewHolder?){
        holder.itemView.expandable_container.animate().alpha(0f).setDuration(200).withEndAction {

            holder.itemView.expandable_container.isVisible = false

            holderToOpen?.let {
                openItem(holderToOpen)
            }

            val animator = ValueAnimator.ofFloat(1f, 0f)
            animator.duration = 200
            animator.addUpdateListener { progress ->
                setExpandProgress(holder, progress.animatedValue as Float)
            }
            animator.start()
        }

    }



    private fun setExpandProgress(
        holder: MenuViewHolder,
        progress: Float
    ) {
        holder.itemView.layoutParams.height =
            (holder.itemView.context.dpToPx(50) + (holder.itemView.context.dpToPx(230) * progress)).toInt()
        holder.itemView.requestLayout()

        holder.itemView.imageViewArrow.rotation = - 180 * progress
    }

    inner class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var quantity = 0

        fun onBind(
            holder: MenuViewHolder,
            menuItem: MenuItem
        ) {

            with(itemView) {
                textViewName.text = "${menuItem.name} ...................................."
                textViewPrice.text = "${menuItem.price} р."
                Glide.with(this).load(menuItem.imageUrl).into(imageViewItem)
                textViewDescription.text = "${menuItem.description}\n${menuItem.weight} гр."


                buttonPlus.setOnClickListener {
                    textViewQuantity.text = (++quantity).toString()
                }
                buttonMinus.setOnClickListener {
                    textViewQuantity.text = (--quantity).toString()
                }
            }
        }

    }
}