package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddStudentActivity extends AppCompatActivity {

    private EditText editTextStudent;
    private EditText editTextGroup;

    private Button buttonSave;
    private StudentDatabase studentDatabase;

    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        initViems();
        studentDatabase = StudentDatabase.getInstance(getApplication());
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveStudent();
            }
        });
    }
    private void initViems(){
        editTextStudent = findViewById(R.id.editTextTextPersonName);
        editTextGroup = findViewById(R.id.editTextGroup);
        buttonSave = findViewById(R.id.buttonSave);
    }

    private void saveStudent(){
        String text = editTextStudent.getText().toString().trim();
        String group = editTextGroup.getText().toString().trim();
        Student student = new Student(text, group);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                studentDatabase.studentDao().add(student);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                });
            }
        });
        thread.start();


    }
    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, AddStudentActivity.class);
        return intent;
    }
}
