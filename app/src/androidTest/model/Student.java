package com.classroom.model;

public class Student extends Person {
    private Course[] enrolled;

    public Student(String firstname, String surname, Course[] coursesEnrolled){
        super(firstname, surname);
        this.enrolled = coursesEnrolled;
    }

    public Course[] getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Course[] enrolled) {
        this.enrolled = enrolled;
    }
}
