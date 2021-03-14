package com.classroom.courses;

import java.util.ArrayList;
import java.util.List;

public class CourseItem {
    private int courseId;
    private String courseName;
    private List<StudentItem> studentItemList;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public List<StudentItem> getStudentItemList() {
        return studentItemList;
    }

    public void setStudentItemList(List<StudentItem> studentItemList) {
        this.studentItemList = studentItemList;
    }

    public CourseItem(String courseName, List<StudentItem> studentItemList) {
        this.courseName = courseName;
        this.studentItemList = studentItemList;
    }
}
