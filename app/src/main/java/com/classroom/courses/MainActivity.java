package com.classroom.courses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_student, main_rv;
    TextView txt_course;
    ArrayList<CourseItem> itemList;
    LinearLayoutManager layoutManager;
    CourseAdapt courseAdapt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_rv = findViewById(R.id.main_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        CourseAdapt courseAdapt = new CourseAdapt(courseItemList());

        main_rv.setAdapter(courseAdapt);
        main_rv.setLayoutManager(layoutManager);

    }

    private List<CourseItem> courseItemList() {

        List<CourseItem> courseItemList = new ArrayList<>();

        CourseItem course1 = new CourseItem("Mathematics",mathStudentItemList());
        courseItemList.add(course1);
        CourseItem course2 = new CourseItem("Data Security",dsStudentItemList());
        courseItemList.add(course2);

        return courseItemList;
    }

    private List<StudentItem> mathStudentItemList() {

        List<StudentItem> mathStudentItemList = new ArrayList<>();

        mathStudentItemList.add(new StudentItem("Billy"));
        mathStudentItemList.add(new StudentItem("Billy"));
        mathStudentItemList.add(new StudentItem("Billy"));

        return mathStudentItemList;
    }

    private List<StudentItem> dsStudentItemList() {

        List<StudentItem> dsStudentItemList = new ArrayList<>();

        dsStudentItemList.add(new StudentItem("Mark"));
        dsStudentItemList.add(new StudentItem("Mark"));
        dsStudentItemList.add(new StudentItem("Mark"));
        dsStudentItemList.add(new StudentItem("Mark"));
        dsStudentItemList.add(new StudentItem("Mark"));
        dsStudentItemList.add(new StudentItem("Mark"));
        dsStudentItemList.add(new StudentItem("Mark"));
        dsStudentItemList.add(new StudentItem("Mark"));
        dsStudentItemList.add(new StudentItem("Mark"));
        dsStudentItemList.add(new StudentItem("Mark"));
        dsStudentItemList.add(new StudentItem("Mark"));
        dsStudentItemList.add(new StudentItem("Mark"));

        return dsStudentItemList;
    }

}