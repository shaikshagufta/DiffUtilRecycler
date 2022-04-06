package com.example.diffutilrecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilrecycler.adapters.PersonAdapter
import com.example.diffutilrecycler.adapters.PersonAdapter2
import java.util.*

import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    //global variable for the PersonAdapter
    lateinit var personAdapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.personRecyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            personAdapter = PersonAdapter()
            adapter = personAdapter
        }

        //add people to the list
        personAdapter.submitList(randomPersonList())
    }

    private fun randomPersonList(): List<Person> {
        val result = mutableListOf<Person>()
        val number = Random.nextInt(20) + 10//generate a random number
        for (i in 0..number) {//loop through the random number
            val name = UUID.randomUUID().toString().take(9)//create random uid
            val age = i * Random.nextInt(20) + 10//random age
            result.add(Person(i, name, age))// add them to the list
        }
       return result
    }
}