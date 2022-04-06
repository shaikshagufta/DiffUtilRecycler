package com.example.diffutilrecycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilrecycler.Person
import com.example.diffutilrecycler.R
import com.example.diffutilrecycler.databinding.ItemPersonBinding


class PersonAdapter : ListAdapter<Person, PersonAdapter.PersonViewHolder>(PersonDC()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        //create and inflate the view
        // val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        // return PersonViewHolder(view)

        // 1 simplest : return PersonViewHolder(ItemPersonBinding.inflate(LayoutInflater.from(parent.context),parent, false))

        return PersonViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_person,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        //bind the data to viewHolder
        holder.bind(getItem(position))
    }

    class PersonViewHolder(private val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(person: Person?) {// or leave it as item and use the same in the method
            binding.person = person
        }

    }

    class PersonDC : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Person, newItem: Person) = oldItem == newItem
    }
}