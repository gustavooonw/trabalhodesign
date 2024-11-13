package com.example.projeto;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")
public class Task {
    @PrimaryKey(autoGenerate = true)
    public int taskId;

    public String title;
    public String details;
    public String dueDate;
}
