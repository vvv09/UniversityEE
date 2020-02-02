package com.valunskii.foxminded.university.repository.entity;

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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
