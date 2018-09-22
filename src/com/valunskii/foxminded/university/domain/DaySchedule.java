package com.valunskii.foxminded.university.domain;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class DaySchedule {
    private DayOfWeek dayOfWeek;
    private Parity parityOfWeek;

    private List<Lesson> lessons = new ArrayList<>();

    public DaySchedule(DayOfWeek dayOfWeek, Parity parityOfWeek) {
        this.dayOfWeek = dayOfWeek;
        this.parityOfWeek = parityOfWeek;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        lessons.remove(lesson);
    }

}
