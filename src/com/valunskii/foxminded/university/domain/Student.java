package com.valunskii.foxminded.university.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(exclude = {"firstName", "middleName", "lastName", "group"})
public class Student {
    private @Getter @Setter int id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String middleName;
    private @Getter @Setter String lastName;
    private @Getter @Setter Group group;
    
    public Student(int id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }    
}
