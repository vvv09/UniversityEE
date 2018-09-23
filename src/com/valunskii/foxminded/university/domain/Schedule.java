package com.valunskii.foxminded.university.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.temporal.ChronoUnit;

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
         * in present business logic there is no sessions as well as vacation between odd and even
         * semester;
         * 
         */

        LocalDate inputDate = date;

        // Getting date of the beginning of academic year;
        LocalDate dayFirstSeptember = LocalDate.of(inputDate.getYear(), 9, 1);
        if (inputDate.getMonthValue() < 9) {
            dayFirstSeptember = dayFirstSeptember.minusYears(1);
        }

        // Getting date of fist Monday for correct calculation of parity in future
        LocalDate dayFirstMonday = dayFirstSeptember.plusDays(1);
        while (dayFirstMonday.getDayOfWeek() != DayOfWeek.MONDAY) {
            dayFirstMonday = dayFirstMonday.plusDays(1);
        }

        // Now getting parity itself
        boolean parity = false;
        if (((ChronoUnit.DAYS.between(dayFirstMonday, inputDate) / 7) % 2) == 0) {
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
                for (Set<Lecture> l : s.getLessons()) {
                    Set<Lecture> studentLesson = new HashSet<>();
                    for (Lecture lec : l) {
                        if (lec.getGroup().equals(student.getGroup())) {
                            studentLesson.add(lec);
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
                for (Set<Lecture> l : s.getLessons()) {
                    Set<Lecture> teacherLesson = new HashSet<>();
                    for (Lecture lec : l) {
                        if (lec.getTeacher().equals(teacher)) {
                            teacherLesson.add(lec);
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
            for (Set<Lecture> l : s.getLessons()) {
                Set<Lecture> studentLesson = new HashSet<>();
                for (Lecture lec : l) {
                    if (lec.getGroup().equals(student.getGroup())) {
                        studentLesson.add(lec);
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
            for (Set<Lecture> l : s.getLessons()) {
                Set<Lecture> teacherLesson = new HashSet<>();
                for (Lecture lec : l) {
                    if (lec.getTeacher().equals(teacher)) {
                        teacherLesson.add(lec);
                    }
                }
                teacherDaySchedule.addLesson(teacherLesson);
            }
            teacherSchedule.addDaySchedule(teacherDaySchedule);
        }
        return teacherSchedule;
    }
}
