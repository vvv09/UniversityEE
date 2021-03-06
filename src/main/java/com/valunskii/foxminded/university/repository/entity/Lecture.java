package com.valunskii.foxminded.university.repository.entity;

import lombok.Getter;

@Getter
public class Lecture {
    private Subject subject;
    private Teacher teacher;
    private Group group;
    private Classroom classroom;

    public Lecture(Subject subject, Teacher teacher, Group group, Classroom classroom) {
        this.subject = subject;
        this.teacher = teacher;
        this.group = group;
        this.classroom = classroom;
    }

    public void createNoSubject() { // TODO Consider situation with "window" in schedule. add to UML

    }
}
