package com.valunskii.foxminded.university.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.Getter;

@Getter
public class Schedule {
    private List<DaySchedule> schedule = new ArrayList<>();

    public void addDaySchedule(DaySchedule daySchedule) {
        schedule.add(daySchedule);
    }

    public void removeDaySchedule(DaySchedule daySchedule) {
        schedule.remove(daySchedule);
    }

    private Parity getParityByDate(LocalDate date) {

        /*
         * NOTE!
         * 
         * in present business logic there is no any vacation between odd and even
         * semester;
         * 
         */

        LocalDate inputDate = date;

        // getting date of the beginning of year;
        LocalDate dayFirstSeptember = LocalDate.of(inputDate.getYear(), 9, 1);
        if (inputDate.getMonthValue() < 9) {
            dayFirstSeptember = dayFirstSeptember.minusYears(1);
        }

        // Getting date of fist Monday for future correct calculation of parity
        LocalDate dayFirstMonday = dayFirstSeptember.plusDays(1);
        while (dayFirstMonday.getDayOfWeek() != DayOfWeek.MONDAY) {
            dayFirstMonday = dayFirstMonday.plusDays(1);
        }

        // Now getting parity itself
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(dayFirstMonday.plusDays(1), inputDate);
        boolean parity = false;
        if (((daysBetween / 7) % 2) == 0) {
            parity = true;
        }
        if (dayFirstSeptember.getDayOfWeek() == DayOfWeek.SUNDAY) {
            // if September 1st is on Sunday then next week(that should be even) becomes an
            // odd one.(mentor's wish)
            parity = !parity;
        }
        if (parity) {
            return Parity.EVEN;
        } else {
            return Parity.ODD;
        }
    }

    public DaySchedule showStudentDaySchedule(Student student, LocalDate date) {
        DaySchedule studentDaySchedule = new DaySchedule(date.getDayOfWeek(), getParityByDate(date));
        System.out.println("(FOR CHECKOUT ONLY. REMOVE THIS LINE IN FUTURE)                  "
                + studentDaySchedule.getDayOfWeek() + " " + studentDaySchedule.getParityOfWeek());
        for (DaySchedule s : schedule) {
            if (s.getDayOfWeek() == studentDaySchedule.getDayOfWeek()
                    && s.getParityOfWeek() == studentDaySchedule.getParityOfWeek()) {
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

    public DaySchedule showTeacherDaySchedule(Teacher teacher, LocalDate date) {
        DaySchedule teacherDaySchedule = new DaySchedule(date.getDayOfWeek(), getParityByDate(date));
        System.out.println("(FOR CHECKOUT ONLY. REMOVE THIS LINE IN FUTURE)                  "
                + teacherDaySchedule.getDayOfWeek() + " " + teacherDaySchedule.getParityOfWeek());
        for (DaySchedule s : schedule) {
            if (s.getDayOfWeek() == teacherDaySchedule.getDayOfWeek()
                    && s.getParityOfWeek() == teacherDaySchedule.getParityOfWeek()) {
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

    public Schedule showStudentSchedule(Student student) {
        Schedule studentSchedule = new Schedule();
        for (DaySchedule s : schedule) {
            DaySchedule studentDaySchedule = new DaySchedule(s.getDayOfWeek(), s.getParityOfWeek());
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

    public Schedule showTeacherSchedule(Teacher teacher) {
        Schedule teacherSchedule = new Schedule();
        for (DaySchedule s : schedule) {
            DaySchedule teacherDaySchedule = new DaySchedule(s.getDayOfWeek(), s.getParityOfWeek());
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
}
