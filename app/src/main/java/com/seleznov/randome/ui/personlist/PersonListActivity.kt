package com.seleznov.randome.ui.personlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.seleznov.randome.R
import com.seleznov.randome.databinding.ActivityPersonListBinding
import com.seleznov.randome.remote.dto.PersonModel
import com.seleznov.randome.ui.persondetail.PersonDetailActivity
import com.seleznov.randome.ui.personlist.recycler.PersonAdapter
import kotlinx.android.synthetic.main.activity_person_list.*

class PersonListActivity : AppCompatActivity() {

    private val binding: ActivityPersonListBinding by lazy {
        DataBindingUtil.setContentView<ActivityPersonListBinding>(
            this,
            R.layout.activity_person_list
        )
    }

    private val onClick: (PersonModel) -> Unit = { person ->
        navigateToDetailScreen(person)
    }

    private lateinit var viewModel: PersonListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(PersonListViewModel::class.java)
        binding.executePendingBindings()

        bindRecycler()

    }

    private fun bindRecycler() {
        val layoutManager = LinearLayoutManager(this)
        val adapter = PersonAdapter(this)
        adapter.setOnClickListener(onClick)
        recyclerPerson.layoutManager = layoutManager
        recyclerPerson.adapter = adapter
        viewModel.personList.observe(this, Observer {
            if (it.size > 0)
                adapter.submitList(it)
        })

        val dividerItemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        recyclerPerson.addItemDecoration(dividerItemDecoration)

    }

    private fun navigateToDetailScreen(person: PersonModel) {
        startActivity(PersonDetailActivity.getIntent(this, person))
    }
}