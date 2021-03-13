package com.classroom.model;

public class Teacher extends Person {
    private Course[] coursesTeaches;

    public Teacher(String firstname, String surname, Course[] coursesTeaches){
        super(firstname, surname);
        this.coursesTeaches = coursesTeaches;
    }

    public Course[] getCoursesTeaches() {
        return coursesTeaches;
    }

    public void setCoursesTeaches(Course[] coursesTeaches) {
        this.coursesTeaches = coursesTeaches;
    }
}
