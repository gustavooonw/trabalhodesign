package com.example.projeto;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void addTask(Task task);

    @Query("SELECT * FROM tasks")
    List<Task> getAllTasks();

    @Delete
    void removeTask(Task task);
}
