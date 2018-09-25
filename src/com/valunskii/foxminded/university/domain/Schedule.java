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

    /**
     * NOTE!
     * 
     * in present business logic there is no sessions as well as vacation between odd and even
     * semester;
     * 
     */
    private Parity getParityByDate(LocalDate date) {
        LocalDate inputDate = date;
        LocalDate dayFirstSeptember = getBeginingAcademicYear(inputDate);
        LocalDate dayFirstMonday = getFirstMonday(dayFirstSeptember);
        return determineWeekParity(dayFirstMonday, dayFirstSeptember, date);    
    }
    
    private LocalDate getBeginingAcademicYear(LocalDate date) {
        LocalDate beginingOfAcademicYear = LocalDate.of(date.getYear(), 9, 1);
        if (date.getMonthValue() < 9) {
            beginingOfAcademicYear = beginingOfAcademicYear.minusYears(1);
        }
        return beginingOfAcademicYear;
    }
    
    private LocalDate getFirstMonday(LocalDate date) {
        LocalDate dayFirstMonday = date;
        while (dayFirstMonday.getDayOfWeek() != DayOfWeek.MONDAY) {
            dayFirstMonday = dayFirstMonday.plusDays(1);
        }
        return dayFirstMonday;
    }
    
    private Parity determineWeekParity(LocalDate firstMonday, LocalDate firstSeptember, LocalDate date) {
        boolean parity = false;
        if (((ChronoUnit.DAYS.between(firstMonday, date) / 7) % 2) == 0) {
            parity = true;
        }
        if (firstSeptember.getDayOfWeek() == DayOfWeek.SATURDAY || firstSeptember.getDayOfWeek() == DayOfWeek.SUNDAY ) {
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
