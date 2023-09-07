package com.bishal.generic_adapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import com.bishal.generic_adapter.model.User
import com.bishal.generic_adapter.databinding.ItemListBinding


/**
 * Author: Bishal Adhikari
 * @Date: 07/09/2023
 */
class UserAdapter : GenericAdapter<User,ItemListBinding> (createDiffCallback()){


    override fun createViewBinding(inflater: LayoutInflater, parent: ViewGroup): ItemListBinding {
        return ItemListBinding.inflate(inflater, parent, false)
    }

    override fun onBindData(binding: ItemListBinding, item: User) {
        with(binding){
            tvName.text = item.name
            tvAddress.text = item.address
        }
    }


    override val filter: Filter = object : Filter() {
        override fun performFiltering(charSequence: CharSequence?): FilterResults {
            return FilterResults().apply {
                values = if (charSequence.isNullOrEmpty()) {
                    filterableList
                } else {
                    filterableList?.filter {
                        it.name.lowercase().contains(charSequence.toString().lowercase())
                    }
                }
            }
        }

        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
            submitList(filterResults?.values as? List<User> ?: filterableList)
        }
    }

}