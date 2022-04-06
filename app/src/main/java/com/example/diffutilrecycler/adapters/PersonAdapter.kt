package com.example.diffutilrecycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilrecycler.Person
import com.example.diffutilrecycler.R


class PersonAdapter : ListAdapter<Person, PersonAdapter.PersonViewHolder>(PersonDC()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        //create and inflate the view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        //bind the data to viewHolder
        holder.bind(getItem(position))
    }

    class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Person?) {
            itemView.findViewById<TextView>(R.id.personIdTV).text = item?.id.toString()
            itemView.findViewById<TextView>(R.id.personAgeTV).text = item?.age.toString()
            itemView.findViewById<TextView>(R.id.personNameTV).text = item?.name.toString()
        }

    }

    class PersonDC : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Person, newItem: Person) = oldItem == newItem
    }
}