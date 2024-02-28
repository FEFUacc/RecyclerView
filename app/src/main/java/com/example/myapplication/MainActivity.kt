package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = mutableListOf<Lesson>()
        for (i in 0..50) {
            list.add(Lesson("Name ${i}", Random.nextInt(0, 2), "Time ${i}", "Class ${Random.nextInt() % 200}"))
        }
        binding.recycler.adapter = LessonListAdapter(list)
    }
}

class Lesson(
    val name: String,
    val type: Int,
    val time: String,
    val cclass: String
)