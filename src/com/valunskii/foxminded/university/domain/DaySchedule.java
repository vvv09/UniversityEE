package com.valunskii.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class DaySchedule {
    private @Getter @Setter String name;
//    private WeekDay day;
//    private WeekParity parity;
    private @Getter List<Lesson> lessons = new ArrayList<>();

    public DaySchedule(String name) {
        this.name = name;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        lessons.remove(lesson);
    }

}
