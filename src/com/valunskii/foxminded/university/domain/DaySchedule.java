package com.valunskii.foxminded.university.domain;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.Getter;

@Getter
public class DaySchedule {
    private DayOfWeek dayOfWeek;
    private Parity parityOfWeek;

    private List<Set<Lecture>> lessons = new ArrayList<>();

    public DaySchedule(DayOfWeek dayOfWeek, Parity parityOfWeek) {
        this.dayOfWeek = dayOfWeek;
        this.parityOfWeek = parityOfWeek;
    }

    public void addLesson(Set<Lecture> setLectures) {
        lessons.add(setLectures);
    }

    public void removeLesson(int lessonId, Set<Lecture> setLecture) {
        if (lessons.size() > lessonId) {
            lessons.remove(lessonId);
        }
    }

    public void addLecture(int lessonId, Lecture newLecture) {
        if (checkIfCorrect(lessonId, newLecture)) {
            lessons.get(lessonId).add(newLecture);
        }
    }

    public void removeLecture(int lessonId, Lecture lecture) {
        if (lessons.size() > lessonId) {
            lessons.get(lessonId).remove(lecture);
        }
    }

    private boolean checkIfCorrect(int lessonId, Lecture newLecture) {
        Set<Lecture> lectures = lessons.get(lessonId);
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

//public void addLesson(Lesson lesson) {
//lessons.add(lesson);
//}
//
//public void removeLesson(Lesson lesson) {
//lessons.remove(lesson);
//}