package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton buttonAddstudent;
    private RecyclerView recyclerViewstudents;
    private StudentAdapter studentAdapter;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new MainViewModel(getApplication());

        initViews();
        studentAdapter = new StudentAdapter();
        studentAdapter.setOnStudentClickListener(new StudentAdapter.OnStudentClickListener() {
            @Override
            public void onStudentClick(Student student) {
                viewModel.remove(student);
            }
        });
        recyclerViewstudents.setAdapter(studentAdapter);

        viewModel.getStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                studentAdapter.setStudents(students);
            }
        });



        buttonAddstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = AddStudentActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });

    }

    private void initViews() {
        recyclerViewstudents = findViewById(R.id.recyclerViewStudent);
        buttonAddstudent = findViewById(R.id.addStudent);
    }
