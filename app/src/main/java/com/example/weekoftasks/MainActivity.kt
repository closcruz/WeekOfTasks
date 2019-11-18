package com.example.weekoftasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weekoftasks.Task.TaskFragment
import com.example.weekoftasks.TaskList.TaskListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currFragment == null) {
            val fragment = TaskListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }




}
