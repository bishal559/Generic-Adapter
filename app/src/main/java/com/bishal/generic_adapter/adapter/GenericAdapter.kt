package com.bishal.generic_adapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


/**
 * Author: Bishal Adhikari
 * @Date: 07/09/2023
 */
abstract class GenericAdapter<T, VB : ViewBinding>(diffUtil: DiffUtil.ItemCallback<T>) : ListAdapter<T, GenericAdapter<T, VB>.ViewHolder>(diffUtil) {


    protected var filterableList: List<T>? = null

    abstract val filter: Filter

    fun submitFilterableList(filterableList: List<T>?) {
        submitList(filterableList)
        this.filterableList = filterableList
    }


    private lateinit var viewBinding: VB

    abstract fun createViewBinding(inflater: LayoutInflater, parent: ViewGroup): VB

    inner class ViewHolder(val binding: VB) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        viewBinding = createViewBinding(inflater, parent)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        onBindData(holder.binding, item)

    }

    abstract fun onBindData(binding: VB, item: T)

    companion object {
        inline fun <reified T> createDiffCallback(): DiffUtil.ItemCallback<T> {
            return object : DiffUtil.ItemCallback<T>() {
                override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
                    return oldItem != newItem
                }
            }
        }
    }
}