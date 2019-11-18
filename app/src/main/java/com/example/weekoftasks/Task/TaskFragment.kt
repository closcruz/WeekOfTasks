package com.example.weekoftasks.Task

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.weekoftasks.R
import com.example.weekoftasks.models.Task

class TaskFragment: Fragment() {
    private lateinit var task: Task
    private lateinit var editTaskTitle: EditText
    private lateinit var editTaskDetail: EditText
    private lateinit var dateCreatedButton: Button
    private lateinit var taskDeadlineButton: Button
    private lateinit var completedCheckbox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        task = Task()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task, container, false)

        editTaskTitle = view.findViewById(R.id.task_title) as EditText
        editTaskDetail = view.findViewById(R.id.task_detail) as EditText
        dateCreatedButton = view.findViewById(R.id.crime_date_created) as Button
        taskDeadlineButton = view.findViewById(R.id.crime_deadline) as Button
        completedCheckbox = view.findViewById(R.id.task_completed) as CheckBox

        dateCreatedButton.apply {
            text = task.dateCreated.toString()
            isEnabled = false
        }

        taskDeadlineButton.apply {
            text = task.deadline.toString()
        }

        return view
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                task.title = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        val detailsWatcher = object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                task.details = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        editTaskTitle.addTextChangedListener(titleWatcher)
        editTaskDetail.addTextChangedListener(detailsWatcher)

        completedCheckbox.apply {
            setOnCheckedChangeListener { _, isChecked ->
                task.isCompleted = isChecked
            }
        }
    }
}