package com.company;

import com.company.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Faculty implements EmailRecipient {
    private String emailAddress;
    private List<Teacher> teachers = new ArrayList<>();

    public void setTeachers(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }
}
