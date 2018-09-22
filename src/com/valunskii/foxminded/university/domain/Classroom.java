package com.valunskii.foxminded.university.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode
public class Classroom {
    private  String name;
    
    public Classroom(String name) {
        this.name = name;
    }
}
