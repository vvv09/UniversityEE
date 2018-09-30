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
    private Map<DayOfWeek, Map<Parity, Map<Lesson, Set<Lecture>>>> schedule = new HashMap<>();

    public void addScheduleForDay(DayOfWeek day, Map<Parity, Map<Lesson, Set<Lecture>>> daySchedule) {
        schedule.put(day, daySchedule);
    }

    public void removeScheduleForDay(DayOfWeek day, Map<Parity, Map<Lesson, Set<Lecture>>> daySchedule) {
        schedule.remove(day, daySchedule);
    }
      
    /**
     * NOTE!
     * 
     * in present business logic there is no sessions as well as vacation between
     * odd and even semester;
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
        if (firstSeptember.getDayOfWeek() == DayOfWeek.SATURDAY || firstSeptember.getDayOfWeek() == DayOfWeek.SUNDAY) {
            parity = !parity;
        }
        if (parity) {
            return Parity.EVEN;
        } else {
            return Parity.ODD;
        }
    }

    public Schedule showStudentDaySchedule(Student student, LocalDate date) {
        Schedule studentDaySchedule = new Schedule();
        Map<Lesson,Set<Lecture>> lessonsOfDay = schedule.get(date.getDayOfWeek()).get(getParityByDate(date));
        Map<Lesson, Set<Lecture>> studentLesson = new HashMap<>();
        for(Lesson lesson: Lesson.values()) {
            if(lessonsOfDay.containsKey(lesson)) {
                Set<Lecture> lectures = lessonsOfDay.get(lesson);
                Set<Lecture> studentLecture = new HashSet<>();
                for (Lecture lecture : lectures) {
                    if (lecture.getGroup().equals(student.getGroup())) {
                        studentLecture.add(lecture);
                    }
                }
                studentLesson.put(lesson, studentLecture);
            }
        }
        Map<Parity, Map<Lesson, Set<Lecture>>> studentParity = new HashMap<>();
        studentParity.put(getParityByDate(date), studentLesson);
        studentDaySchedule.addScheduleForDay(date.getDayOfWeek(), studentParity);
        return studentDaySchedule;
    }

    public Schedule showTeacherDaySchedule(Teacher teacher, LocalDate date) {
        Schedule teacherDaySchedule = new Schedule();
        Map<Lesson,Set<Lecture>> lessonsOfDay = schedule.get(date.getDayOfWeek()).get(getParityByDate(date));
        Map<Lesson, Set<Lecture>> teacherLesson = new HashMap<>();
        for(Lesson lesson: Lesson.values()) {
            if(lessonsOfDay.containsKey(lesson)) {
                Set<Lecture> lectures = lessonsOfDay.get(lesson);
                Set<Lecture> teacherLecture = new HashSet<>();
                for (Lecture lecture : lectures) {
                    if (lecture.getTeacher().equals(teacher)) {
                        teacherLecture.add(lecture);
                    }
                }
                teacherLesson.put(lesson, teacherLecture);
            }
        }
        Map<Parity, Map<Lesson, Set<Lecture>>> teacherParity = new HashMap<>();
        teacherParity.put(getParityByDate(date), teacherLesson);
        teacherDaySchedule.addScheduleForDay(date.getDayOfWeek(), teacherParity);
        return teacherDaySchedule;
    }

    public Schedule showStudentSchedule(Student student) {
        Schedule studentSchedule = new Schedule();
        Map<Parity, Map<Lesson, Set<Lecture>>> studentParity = new HashMap<>();
        Map<Lesson, Set<Lecture>> studentLesson = new HashMap<>();

        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            studentParity = new HashMap<>();
            for (Parity parity : Parity.values()) {
                studentLesson = new HashMap<>();
                for (Lesson lesson : Lesson.values()) {
                    if (schedule.containsKey(dayOfWeek)) {
                        Map<Parity, Map<Lesson, Set<Lecture>>> lessonPair = schedule.get(dayOfWeek);
                        if (lessonPair.containsKey(parity)) {
                            Map<Lesson, Set<Lecture>> lessons = lessonPair.get(parity);
                            if (lessons.containsKey(lesson)) {
                                Set<Lecture> lectures = lessons.get(lesson);
                                Set<Lecture> studentLecture = new HashSet<>();
                                for (Lecture lecture : lectures) {
                                    if (lecture.getGroup().equals(student.getGroup())) {
                                        studentLecture.add(lecture);
                                    }
                                }
                                studentLesson.put(lesson, studentLecture);
                            }
                        }
                    }
                }
                studentParity.put(parity, studentLesson);
            }
            studentSchedule.addScheduleForDay(dayOfWeek, studentParity);
        }
        return studentSchedule;
    }

    public Schedule showTeacherSchedule(Teacher teacher) {
        Schedule teacherSchedule = new Schedule();
        Map<Parity, Map<Lesson, Set<Lecture>>> teacherParity = new HashMap<>();
        Map<Lesson, Set<Lecture>> teacherLesson = new HashMap<>();

        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            teacherParity = new HashMap<>();
            for (Parity parity : Parity.values()) {
                teacherLesson = new HashMap<>();
                for (Lesson lesson : Lesson.values()) {
                    if (schedule.containsKey(dayOfWeek)) {
                        Map<Parity, Map<Lesson, Set<Lecture>>> lessonPair = schedule.get(dayOfWeek);
                        if (lessonPair.containsKey(parity)) {
                            Map<Lesson, Set<Lecture>> lessons = lessonPair.get(parity);
                            if (lessons.containsKey(lesson)) {
                                Set<Lecture> lectures = lessons.get(lesson);
                                Set<Lecture> studentLecture = new HashSet<>();
                                for (Lecture lecture : lectures) {
                                    if (lecture.getTeacher().equals(teacher)) {
                                        studentLecture.add(lecture);
                                    }
                                }
                                teacherLesson.put(lesson, studentLecture);
                            }
                        }
                    }
                }
                teacherParity.put(parity, teacherLesson);
            }
            teacherSchedule.addScheduleForDay(dayOfWeek, teacherParity);
        }
        return teacherSchedule;
    }
}
