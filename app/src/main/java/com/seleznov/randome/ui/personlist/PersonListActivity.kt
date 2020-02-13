package com.seleznov.randome.ui.personlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.seleznov.randome.R
import com.seleznov.randome.databinding.ActivityPersonListBinding

class PersonListActivity : AppCompatActivity() {

    val binding: ActivityPersonListBinding by lazy {
        DataBindingUtil.setContentView<ActivityPersonListBinding>(
            this,
            R.layout.activity_person_list
        )
    }


    lateinit var viewModel: PersonListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(PersonListViewModel::class.java)
        binding.executePendingBindings()
    }
}