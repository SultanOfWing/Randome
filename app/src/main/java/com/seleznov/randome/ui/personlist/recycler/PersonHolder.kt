package com.seleznov.randome.ui.personlist.recycler

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.seleznov.randome.databinding.HolderPersonBinding
import com.seleznov.randome.remote.dto.PersonModel
import com.seleznov.randome.util.concat
import com.seleznov.randome.util.loadImage

class PersonHolder(private val binding: HolderPersonBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PersonModel?, context: Context, onClick: ((item: PersonModel) -> Unit)?) {

        item?.let { person ->
            val picture = person.picture?.thumbnail
            picture?.let { binding.imagePerson.loadImage(it, context) }
            person.name?.let { name ->
                binding.namePerson.text = name.first.concat(name.last)
            }
            binding.emailPerson.text = person.email

            binding.root.setOnClickListener {
                onClick?.invoke(item)
            }
        }


    }

}