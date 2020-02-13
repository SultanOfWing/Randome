package com.seleznov.randome.ui.persondetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.seleznov.randome.R
import com.seleznov.randome.databinding.ActivityPersonDetailBinding

class PersonDetailActivity : AppCompatActivity() {

    val binding: ActivityPersonDetailBinding by lazy {
        DataBindingUtil.setContentView<ActivityPersonDetailBinding>(
            this,
            R.layout.activity_person_list
        )
    }


    lateinit var viewModel: PersonDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(PersonDetailViewModel::class.java)
        binding.executePendingBindings()
    }
}