package com.valunskii.foxminded.university.domain;

import lombok.Getter;
import lombok.Setter;

public class Lecture {
    private @Getter @Setter Subject subject;
    private @Getter @Setter Teacher teacher;
    private @Getter @Setter Group group;
    private @Getter @Setter Classroom classroom;

    public Lecture(Subject subject, Teacher teacher, Group group, Classroom classroom) {
        this.subject = subject;
        this.teacher = teacher;
        this.group = group;
        this.classroom = classroom;
    }

    public void createNoSubject() { // TODO Consider situation with "window" in schedule. add to UML

    }

}
