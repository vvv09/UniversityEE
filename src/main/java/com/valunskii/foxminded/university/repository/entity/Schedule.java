package com.valunskii.foxminded.university.repository.entity;

import java.util.Set;
import java.time.DayOfWeek;

public class Schedule {
    private DayOfWeek dayOfWeek;
    private Parity parity;
    private Lesson lesson;
    private Set<Lecture> lectures;

    public Schedule(DayOfWeek dayOfWeek, Parity parity, Lesson lesson) {
        this.dayOfWeek = dayOfWeek;
        this.parity = parity;
        this.lesson = lesson;
    }

    public Schedule() {

    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Parity getParity() {
        return parity;
    }

    public void setParity(Parity parity) {
        this.parity = parity;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }
}
