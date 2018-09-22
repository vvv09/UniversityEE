package com.valunskii.foxminded.university.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class Lesson {

    private Set<Lecture> lectures = new HashSet<>();

    public void addLecture(Lecture lecture) {
        if (checkIfCorrect(lecture)) {
            lectures.add(lecture);
        }
    }

    public void removeLecture(Lecture lecture) {
        lectures.remove(lecture);
    }

    private boolean checkIfCorrect(Lecture newLecture) {
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
