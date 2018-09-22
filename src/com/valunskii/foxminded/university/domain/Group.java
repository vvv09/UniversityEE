package com.valunskii.foxminded.university.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode(exclude = "students") //name is enough, since groups can't be called identically...
public class Group {
    private @Setter String name;
    private Set<Student> students = new HashSet<>();
        
    public Group(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }
}
