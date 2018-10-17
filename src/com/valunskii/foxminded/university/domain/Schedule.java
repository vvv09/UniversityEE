package com.valunskii.foxminded.university.domain;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Schedule {
    private String dayOfWeek = "пусто";
    private String parity = "пусто";
    private String lesson = "пусто";
    private @Setter Set<Lecture> lectures;
    
    public Schedule(String dayOfWeek, String parity, String lesson) {
        this.dayOfWeek = dayOfWeek;
        this.parity = parity;
        this.lesson = lesson;
    }

    public Schedule() {
        
    }
    
}
