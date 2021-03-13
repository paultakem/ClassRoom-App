package com.classroom.model;

public class Course {
    private String name;
    private Student[] participants;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getParticipants() {
        return participants;
    }

    public void setParticipants(Student[] participants) {
        this.participants = participants;
    }
}
