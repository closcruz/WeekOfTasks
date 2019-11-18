package com.example.weekoftasks.TaskList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weekoftasks.R
import com.example.weekoftasks.models.Task
import java.text.DateFormat
import java.text.SimpleDateFormat

private const val TAG = "TaskListFragment"

class TaskListFragment: Fragment() {

    private lateinit var taskRecyclerView: RecyclerView
    private var adaper: TaskAdapter? = null

    private val taskListViewModel: TaskListViewModel by lazy {
        ViewModelProviders.of(this).get(TaskListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total dummy tasks created: ${taskListViewModel.tasks.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task_list, container, false)

        taskRecyclerView = view.findViewById(R.id.task_recycler_view) as RecyclerView
        taskRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    private fun updateUI() {
        val tasks = taskListViewModel.tasks
        adaper = TaskAdapter(tasks)
        taskRecyclerView.adapter = adaper
    }

    private inner class TaskHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {

        private lateinit var task: Task

        private val titleTextView: TextView = itemView.findViewById(R.id.task_title)
        private val dateStartedTextView: TextView = itemView.findViewById(R.id.task_start_date)
        private val dateDeadlineTextView: TextView = itemView.findViewById(R.id.task_deadline)
        private val finishedTaskImageView: ImageView = itemView.findViewById(R.id.task_finished_check)


        init {
            itemView.setOnClickListener(this)
        }

        fun bind(task: Task) {
            // Set date formatter to "Name of day, hour:minutes am/pm"
            val df: SimpleDateFormat = DateFormat
                .getDateTimeInstance() as SimpleDateFormat
            df.applyPattern("EEEE, h:mm a")

            this.task = task
            titleTextView.text = this.task.title
            dateStartedTextView.text = df.format(this.task.dateCreated)
            dateDeadlineTextView.text = df.format(this.task.deadline)
            finishedTaskImageView.visibility = if (task.isCompleted) {
                View.VISIBLE
            } else {
                View.GONE
            }

        }

        override fun onClick(v: View?) {
            Toast.makeText(context, "${task.title} pressed!", Toast.LENGTH_SHORT).show()
        }
    }

    // TODO: Add view type for differing time left to complete task (A lot of time, close to deadline, urgent)
    private inner class TaskAdapter(var tasks: List<Task>): RecyclerView.Adapter<TaskHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
            val view = layoutInflater.inflate(R.layout.list_item_task, parent, false)
            return TaskHolder(view)
        }

        override fun onBindViewHolder(holder: TaskHolder, position: Int) {
            val task = tasks[position]
            holder.bind(task)
        }

        override fun getItemCount() = tasks.size
    }

    companion object {
        fun newInstance(): TaskListFragment {
            return TaskListFragment()
        }
    }
}