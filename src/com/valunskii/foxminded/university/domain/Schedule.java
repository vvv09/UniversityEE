package com.valunskii.foxminded.university.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.time.temporal.ChronoUnit;

import lombok.Getter;

@Getter
public class Schedule {
    private DayOfWeek dayOfWeek;
    private Parity parity;
    private Lesson lesson;
    private Set<Lecture> lectures;
    
    public Schedule(DayOfWeek dayOfWeek, Parity parity, Lesson lesson, Set<Lecture> lectures) {
        this.dayOfWeek = dayOfWeek;
        this.parity = parity;
        this.lesson = lesson;
        this.lectures =  lectures;
    }
    
}
