package com.valunskii.foxminded.university.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(exclude = {"firstName", "middleName", "lastName", "group"}) //id is quite enough
public class Student {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Group group;
    
    public Student(int id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }    
}
