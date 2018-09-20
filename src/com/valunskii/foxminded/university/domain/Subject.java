package com.valunskii.foxminded.university.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class Subject {
    private @Getter @Setter String name;
    
    public Subject(String name) {
        this.name = name;
    }
    
}
