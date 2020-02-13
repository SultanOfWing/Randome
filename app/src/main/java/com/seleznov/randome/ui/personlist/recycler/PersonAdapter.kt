package com.seleznov.randome.ui.personlist.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.seleznov.randome.databinding.HolderPersonBinding
import com.seleznov.randome.remote.dto.PersonModel

class PersonAdapter(val context: Context) : PagedListAdapter<PersonModel, PersonHolder>(
    PersonModel.diffCallback
) {

    private val inflater = LayoutInflater.from(context)
    protected var listener: ((item: PersonModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val binding = HolderPersonBinding.inflate(inflater, parent, false)
        return PersonHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.bind(getItem(position), context, listener)
    }

    fun setOnClickListener(listener: (item: PersonModel) -> Unit) {
        this.listener = listener
    }
}