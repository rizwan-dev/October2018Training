package com.riztech.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.riztech.recyclerview.data.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvStudentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize recycler view
        rvStudentList = findViewById(R.id.rvStudentList);

        // Create data
        List<Student> studentList = fetchMockStudents();

        // Create object of adapter
        StudentAdapter studentAdapter = new StudentAdapter(studentList);

        // Layoutmanager for orientation
        rvStudentList.setLayoutManager(new LinearLayoutManager(this));

        //SetAdapter on recyclerview
        rvStudentList.setAdapter(studentAdapter);


    }


    private List<Student> fetchMockStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Akshay", "Viman Nagar", "87768767678", "B.E", "PICT"));
        studentList.add(new Student("Raj", "Kharadi", "87768767678", "MCA", "PICT"));
        studentList.add(new Student("Gokul", "Kalyani Nagar", "87768767678", "B.E", "PICT"));
        studentList.add(new Student("Tejashree", "Mundwa", "87768767678", "B.E", "PICT"));
        studentList.add(new Student("Shubhangi", "Chandan Nagar", "87768767678", "BSc", "PICT"));
        return studentList;
    }
}
