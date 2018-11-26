package com.valunskii.foxminded.university.repository.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Group {
    private int id;
    private @Setter String name;

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
