package com.example.maytheforcebewith.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.maytheforcebewith.R
import com.example.maytheforcebewith.base.model.People
import com.example.maytheforcebewith.databinding.ItemPeopleBinding
import com.example.maytheforcebewith.util.helpers.AdapterItemsContract

class PeopleAdapter(private var people: MutableList<People>, private val clickListener : (String) -> Unit) : RecyclerView.Adapter<PeopleAdapter.PeoplesViewHolder>(),
    AdapterItemsContract {

    override fun replaceItems(list: List<*>) {
        if (people.isNullOrEmpty()) {
            people = list as MutableList<People>
        } else {
            people.addAll(list as MutableList<People>)
        }
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeoplesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemPeopleBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_people, parent, false)

        return PeoplesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeoplesViewHolder, position: Int) {
        holder.bind(people[position], clickListener)
    }

    override fun getItemCount(): Int {
        return people.size
    }
    class PeoplesViewHolder(val binding: ItemPeopleBinding) : RecyclerView.ViewHolder(binding.root) {
        private val peopleViewModel = PeopleItemViewModel()
        fun bind(people: People, clickListener: (String) -> Unit) {
            peopleViewModel.bind(people)
            binding.root.setOnClickListener { clickListener(people.url)}
            binding.peopleViewModel = peopleViewModel
            binding.executePendingBindings()
        }

    }
}