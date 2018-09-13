package com.valunskii.foxminded.university.domain;

public class Student {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;

    public Student(int id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}
