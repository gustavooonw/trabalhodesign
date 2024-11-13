package com.example.projeto;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class AddProject extends AppCompatActivity {
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project);

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "project-db").allowMainThreadQueries().build();

        findViewById(R.id.btnSaveTask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText projectName = findViewById(R.id.etTaskTitle);
                EditText projectDescription = findViewById(R.id.etTaskDetails);
                EditText projectDeadline = findViewById(R.id.etTaskDueDate);

                Task newTask = new Task();
                newTask.title = projectName.getText().toString();
                newTask.details = projectDescription.getText().toString();
                newTask.dueDate = projectDeadline.getText().toString();

                database.taskDao().addTask(newTask);

                Toast.makeText(AddProject.this, "Projeto salvo com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
