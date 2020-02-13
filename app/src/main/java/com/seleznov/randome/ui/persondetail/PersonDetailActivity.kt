package com.seleznov.randome.ui.persondetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.seleznov.randome.R
import com.seleznov.randome.databinding.ActivityPersonDetailBinding
import com.seleznov.randome.remote.dto.PersonModel
import com.seleznov.randome.util.concat
import com.seleznov.randome.util.loadImage
import kotlinx.android.synthetic.main.activity_person_detail.*

class PersonDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "EXTRA_PERSON"

        fun getIntent(context: Context, person: PersonModel) =
            Intent(context, PersonDetailActivity::class.java)
                .putExtra(EXTRA_PERSON, person)
    }

    private val binding: ActivityPersonDetailBinding by lazy {
        DataBindingUtil.setContentView<ActivityPersonDetailBinding>(
            this,
            R.layout.activity_person_detail
        )
    }


    private lateinit var viewModel: PersonDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(PersonDetailViewModel::class.java)
        binding.executePendingBindings()

        val person = intent.getParcelableExtra<PersonModel?>(EXTRA_PERSON)
        person?.let { initPerson(it) }
    }

    private fun initPerson(person: PersonModel) {
        person.picture?.large?.let { imageDetail.loadImage(it, this) }
        person.name?.let { nameDetail.text = it.first.concat(it.last) }
        genderDetail.text = person.gender
        emailDetail.text = person.email
        phoneDetail.text = person.phone

    }
}