package com.company;

import java.util.ArrayList;
import java.util.List;

public class University implements EmailRecipient {

    private String name;
    private String emailAddress;

    private List<Faculty> faculties = new ArrayList<>();

    public University(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Faculty facultiy) {
        this.faculties.add(facultiy);
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

}
