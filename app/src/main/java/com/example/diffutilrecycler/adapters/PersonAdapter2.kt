package com.example.diffutilrecycler.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.View.OnClickListener
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.diffutilrecycler.Person
import com.example.diffutilrecycler.R

class PersonAdapter2(private val interaction: Interaction? = null) :
    ListAdapter<Person, PersonAdapter2.PersonViewHolder>(PersonDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PersonViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
    )

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Person) {
            itemView.findViewById<TextView>(R.id.personIdTV).text = item.id.toString()
            itemView.findViewById<TextView>(R.id.personAgeTV).text = item.age.toString()
            itemView.findViewById<TextView>(R.id.personNameTV).text = item.name
        }
    }

    interface Interaction {
    }

    private class PersonDC : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Person, newItem: Person) = oldItem == newItem
    }
}