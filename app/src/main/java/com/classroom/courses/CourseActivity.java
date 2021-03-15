package com.classroom.courses;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.classroom.R;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    RecyclerView main_rv;
    TextView txt_course;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        main_rv = findViewById(R.id.main_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(CourseActivity.this);
        CourseAdapt courseAdapt = new CourseAdapt(courseItemList());

        main_rv.setAdapter(courseAdapt);
        main_rv.setLayoutManager(layoutManager);

    }

    private List<CourseItem> courseItemList() {

        List<CourseItem> courseItemList = new ArrayList<>();

        CourseItem course1 = new CourseItem("Discrete Mathematics",mathStudentItemList());
        courseItemList.add(course1);
        CourseItem course2 = new CourseItem("Data Security",dsStudentItemList());
        courseItemList.add(course2);

        return courseItemList;
    }

    private List<StudentItem> mathStudentItemList() {

        List<StudentItem> mathStudentItemList = new ArrayList<>();

        mathStudentItemList.add(new StudentItem("Billy"));
        mathStudentItemList.add(new StudentItem("Kate"));
        mathStudentItemList.add(new StudentItem("Marcus"));

        return mathStudentItemList;
    }

    private List<StudentItem> dsStudentItemList() {

        List<StudentItem> dsStudentItemList = new ArrayList<>();

        dsStudentItemList.add(new StudentItem("Mark"));
        dsStudentItemList.add(new StudentItem("Lisa"));
        dsStudentItemList.add(new StudentItem("Greg"));
        dsStudentItemList.add(new StudentItem("Mary"));


        return dsStudentItemList;
    }

}