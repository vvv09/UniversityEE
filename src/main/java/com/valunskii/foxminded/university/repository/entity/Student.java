package com.valunskii.foxminded.university.repository.entity;

import lombok.Getter;

@Getter
public class Student {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Group group;

    public Student(int id, String firstName, String middleName, String lastName, Group group) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.group = group;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) { // id is quite enough
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
