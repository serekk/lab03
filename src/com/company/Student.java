package com.company;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    public Student(String firstName, String lastName, String emailAddress, String groupId) {
        super(firstName, lastName, emailAddress);
        this.groupId = groupId;
    }

    private String groupId;
    private List<Double> grades = new ArrayList<>();

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void addGrade(double grade) {
        this.grades.add(grade);
    }

    public Double getGradesAverage() {
        Double sum = 0.0;

        for (double i : grades){
            sum += i;
        }
        System.out.println(sum);
        System.out.println(grades.size());
        return sum / grades.size();

    }
}
