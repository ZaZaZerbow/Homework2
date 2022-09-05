package com.example.todolist;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1)

public abstract class StudentDatabase extends RoomDatabase {
    private static StudentDatabase instance = null;
    private static final String DB_NAME = "notes.db";
    public static StudentDatabase getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                        application, StudentDatabase.class, DB_NAME
                    )

                    .build();
        }
        return instance;
    }
    public abstract StudentDao studentDao();
}
