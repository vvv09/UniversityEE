package com.valunskii.foxminded.university.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class Classroom {
    private @Getter @Setter String name;
    
    public Classroom(String name) {
        this.name = name;
    }
}
