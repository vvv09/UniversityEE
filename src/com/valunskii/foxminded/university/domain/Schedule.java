package com.valunskii.foxminded.university.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lombok.Getter;

public class Schedule {
    private @Getter List<DaySchedule> schedule = new ArrayList<>();

    public void addDaySchedule(DaySchedule daySchedule) {
        schedule.add(daySchedule);
    }

    public void removeDaySchedule(DaySchedule daySchedule) {
        schedule.remove(daySchedule);
    }

    private DaySchedule showStudentDaySchedule(Student student, String day) {
        return null;
    }

    public DaySchedule showStudentDaySchedule(Student student, Calendar day) {
        String name = getDayNameByDate(day);

        DaySchedule studentDaySchedule = null;
        for (DaySchedule s : schedule) {
            if (s.getName().equals(name)) {
                studentDaySchedule = new DaySchedule(s.getName());
                for (Lesson l : s.getLessons()) {
                    Lesson studentLesson = new Lesson();
                    for (Lecture lec : l.getLectures()) {
                        if (lec.getGroup().equals(student.getGroup())) {
                            studentLesson.addLecture(lec);
                        }
                    }
                    studentDaySchedule.addLesson(studentLesson);
                }
            }
        }
        return studentDaySchedule;
    }

    public Schedule showStudentSchedule(Student student) {
        Schedule studentSchedule = new Schedule();
        for (DaySchedule s : schedule) {
            DaySchedule studentDaySchedule = new DaySchedule(s.getName());
            for (Lesson l : s.getLessons()) {
                Lesson studentLesson = new Lesson();
                for (Lecture lec : l.getLectures()) {
                    if (lec.getGroup().equals(student.getGroup())) {
                        studentLesson.addLecture(lec);
                    }
                }
                studentDaySchedule.addLesson(studentLesson);
            }
            studentSchedule.addDaySchedule(studentDaySchedule);
        }
        return studentSchedule;
    }

    private DaySchedule showTeacherDaySchedule(Teacher teacher, String day) {
        return null;
    }

    public DaySchedule showTeacherDaySchedule(Teacher teacher, Calendar day) {
        String name = getDayNameByDate(day);

        DaySchedule teacherDaySchedule = null;
        for (DaySchedule s : schedule) {
            if (s.getName().equals(name)) {
                teacherDaySchedule = new DaySchedule(s.getName());
                for (Lesson l : s.getLessons()) {
                    Lesson teacherLesson = new Lesson();
                    for (Lecture lec : l.getLectures()) {
                        if (lec.getTeacher().equals(teacher)) {
                            teacherLesson.addLecture(lec);
                        }
                    }
                    teacherDaySchedule.addLesson(teacherLesson);
                }
            }
        }
        return teacherDaySchedule;
    }

    public Schedule showTeacherSchedule(Teacher teacher) {
        Schedule teacherSchedule = new Schedule();
        for (DaySchedule s : schedule) {
            DaySchedule teacherDaySchedule = new DaySchedule(s.getName());
            for (Lesson l : s.getLessons()) {
                Lesson teacherLesson = new Lesson();
                for (Lecture lec : l.getLectures()) {
                    if (lec.getTeacher().equals(teacher)) {
                        teacherLesson.addLecture(lec);
                    }
                }
                teacherDaySchedule.addLesson(teacherLesson);
            }
            teacherSchedule.addDaySchedule(teacherDaySchedule);
        }
        return teacherSchedule;
    }

    private String getDayNameByDate(Calendar day) {
        int dayOfWeek = day.get(Calendar.DAY_OF_WEEK);
        String dayName = "";
        switch (dayOfWeek) {
        case 1:
            System.out.println("В воскресенье университете закрыт");
            break;
        case 2:
            dayName = "ПН неч";
            break;

        case 3:
            dayName = "ВТ неч";
            break;

        case 4:
            dayName = "СР неч";
            break;

        case 5:
            dayName = "ЧТ неч";
            break;

        case 6:
            dayName = "ПТ неч";
            break;

        case 7:
            dayName = "СБ неч";
            break;

        default:
            break;
        }
        return dayName;
    }
}
