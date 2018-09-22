package com.valunskii.foxminded.university.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode
public class Subject {
    private String name;
    
    public Subject(String name) {
        this.name = name;
    }
    
}
