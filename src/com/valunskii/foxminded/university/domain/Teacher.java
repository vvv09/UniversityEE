package com.valunskii.foxminded.university.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@EqualsAndHashCode(exclude = {"firstName", "middleName", "lastName"})
public class Teacher {
    private @Getter @Setter int id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String middleName;
    private @Getter @Setter String lastName;
    
    public Teacher(int id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }   
}
