package com.valunskii.foxminded.university.domain;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Getter;

@Getter
public class DaySchedule {
    private DayOfWeek dayOfWeek;
    private Parity parityOfWeek;

    private Map<Lesson,Set<Lecture>> lessons = new HashMap<>();

    public DaySchedule(DayOfWeek dayOfWeek, Parity parityOfWeek) {
        this.dayOfWeek = dayOfWeek;
        this.parityOfWeek = parityOfWeek;
    }

    public void addLesson(Lesson lesson, Set<Lecture> setLectures) {
        lessons.put(lesson, setLectures);
    }

    public void removeLesson(Lesson lesson) {
        if (lessons.containsKey(lesson)) {
            lessons.remove(lesson);
        }
    }

    public void addLecture(Lesson lesson, Lecture newLecture) {
        if (checkIfCorrect(lesson, newLecture)) {
            lessons.get(lesson).add(newLecture);
        }
    }

    public void removeLecture(Lesson lesson, Lecture lecture) {
        if (lessons.containsKey(lesson)) {
            lessons.get(lesson).remove(lecture);
        }
    }

    private boolean checkIfCorrect(Lesson lesson, Lecture newLecture) {
        Set<Lecture> lectures = lessons.get(lesson);
        for (Lecture exictingLecture : lectures) {
            if (newLecture.getSubject().equals(exictingLecture.getSubject())) {
                System.out.println("Ошибка добавления занятия: Один и тот же предмет сразу у нескольких групп");
                return false;
            }
            if (newLecture.getClassroom().equals(exictingLecture.getClassroom())) {
                System.out.println(
                        "Ошибка добавления занятия: аудитория " + newLecture.getClassroom().getName() + " уже занята");
                return false;
            }
            if (newLecture.getTeacher().equals(exictingLecture.getTeacher())) {
                System.out.println("Ошибка добавления занятия: преподаватель занят");
                return false;
            }
            if (newLecture.getGroup().equals(exictingLecture.getGroup())) {
                System.out.println(
                        "Ошибка добавления занятия: у группы " + newLecture.getGroup().getName() + " уже есть занятие");
                return false;
            }
        }
        return true;
    }
}