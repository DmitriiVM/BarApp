package com.example.barapp.ui.adapters

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
import kotlinx.android.synthetic.main.menu_item.view.*

class MenuRecyclerViewAdapter() : RecyclerView.Adapter<MenuRecyclerViewAdapter.MenuViewHolder>() {

    private var menu: List<MenuItem> = arrayListOf()
    private var expandedItem: MenuItem? = null
    private lateinit var recyclerView: RecyclerView

    fun setMenu(menu: List<MenuItem>) {
        this.menu = menu
        notifyDataSetChanged()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder =
        MenuViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
        )

    override fun getItemCount(): Int = menu.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = menu[position]
        val itemView = holder.itemView

        initExpandedItemView(item, itemView)
        holder.onBind(item)

        itemView.setOnClickListener {
            when (expandedItem) {
                null -> {
                    openItemWithAnimation(itemView)
                    expandedItem = item
                }
                item -> {
                    closeItemWithAnimation(itemView, null)
                    expandedItem = null
                }
                else -> {
                    val previousExpandedViewHolder =
                        findPreviousExpandedViewHolder()

                    if (previousExpandedViewHolder != null) {
                        closeItemWithAnimation(previousExpandedViewHolder.itemView, holder)
                    } else {
                        openItemWithAnimation(itemView)
                    }

                    expandedItem = item
                }
            }
        }
    }

    private fun initExpandedItemView(item: MenuItem, itemView: View) {
        if (item == expandedItem) {
            itemView.expandable_container.isVisible = true
            setExpandProgress(itemView, 1f)
        } else {
            itemView.expandable_container.isGone = true
            setExpandProgress(itemView, 0f)
        }
    }

    private fun findPreviousExpandedViewHolder(): MenuViewHolder? {
        val expandedItemPosition = menu.indexOf(expandedItem!!)
        return recyclerView.findViewHolderForAdapterPosition(expandedItemPosition) as? MenuViewHolder
    }

    private fun openItemWithAnimation(itemView: View) {
        createAnimator(itemView).apply {
            doOnEnd {
                with(itemView.expandable_container) {
                    isVisible = true
                    alpha = 0f
                    animate().alpha(1f).setDuration(200)
                }
            }
            start()
        }
    }

    private fun closeItemWithAnimation(itemView: View, holderToOpen: MenuViewHolder?) {
        itemView.expandable_container.animate().alpha(0f)
            .setDuration(200)
            .withEndAction {
                itemView.expandable_container.isVisible = false
                holderToOpen?.let {
                    openItemWithAnimation(holderToOpen.itemView)
                }
                createAnimator(itemView).reverse()
            }
    }

    private fun createAnimator(itemView: View): ValueAnimator {
        return ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 200
            addUpdateListener { progress ->
                setExpandProgress(itemView, progress.animatedValue as Float)
            }
        }
    }

    private fun setExpandProgress(itemView: View, progress: Float) {
        with(itemView){
            layoutParams.height =
                (itemView.context.dpToPx(50) + (itemView.context.dpToPx(230) * progress)).toInt()
            imageViewHeader.rotation = -180 * progress
            requestLayout()
        }
    }

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var quantity = 0

        fun onBind(menuItem: MenuItem) {

            with(itemView) {
                textViewName.text = "${menuItem.name} ...................................."
                textViewPrice.text = "${menuItem.price} р."
                Glide.with(this).load(menuItem.imageUrl).into(imageViewItem)
                textViewDescription.text = "${menuItem.description}\n${menuItem.weight} гр."

                buttonPlus.setOnClickListener {
                    textViewQuantity.text = (++quantity).toString()
                }
                buttonMinus.setOnClickListener {
                    if (textViewQuantity.text.toString().toInt() > 0) {
                        textViewQuantity.text = (--quantity).toString()
                    }
                }
            }
        }

    }
}