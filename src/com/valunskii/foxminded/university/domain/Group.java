package com.valunskii.foxminded.university.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(exclude = "students") //достаточно только имени группы, поскольку группы не могут называться одинаково...
public class Group {
    private @Getter @Setter String name;
    private @Getter Set<Student> students = new HashSet<>();
        
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
