package com.example.todolist;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity(tableName = "students")
public class Student {
    @PrimaryKey(autoGenerate = true)

    private int id;
    private String text;
    private String group;

    public Student(int id, String text, String group) {
        this.id = id;
        this.text = text;
        this.group = group;
    }
    @Ignore
    public Student(String text, String group) {
        this.text = text;
        this.group = group;
        id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getGroup() {
        return group;
    }

    public void setPriority(String priority) {
        this.group = group;
    }
}
