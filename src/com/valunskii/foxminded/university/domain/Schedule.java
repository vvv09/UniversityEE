package com.valunskii.foxminded.university.domain;

import java.util.Set;
import java.time.DayOfWeek;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Schedule {
    private DayOfWeek dayOfWeek;
    private Parity parity;
    private Lesson lesson;
    private @Setter Set<Lecture> lectures;
    
    public Schedule(DayOfWeek dayOfWeek, Parity parity, Lesson lesson) {
        this.dayOfWeek = dayOfWeek;
        this.parity = parity;
        this.lesson = lesson;
    }

    public Schedule() {
        
    }
    
}
