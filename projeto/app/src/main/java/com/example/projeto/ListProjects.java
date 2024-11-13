package com.example.projeto;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

public class ListProjects extends AppCompatActivity {
    private RecyclerView taskRecyclerView;
    private TaskAdapter taskAdapter;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);

        taskRecyclerView = findViewById(R.id.recyclerViewTasks);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "task-db").allowMainThreadQueries().build();
        List<Task> tasks = database.taskDao().getAllTasks();
        taskAdapter = new TaskAdapter(tasks);
        taskRecyclerView.setAdapter(taskAdapter);
    }
}
