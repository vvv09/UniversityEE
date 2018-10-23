package com.valunskii.foxminded.university.repository.dao;

import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Classroom;
import com.valunskii.foxminded.university.repository.entity.Group;
import com.valunskii.foxminded.university.repository.entity.Lecture;
import com.valunskii.foxminded.university.repository.entity.Lesson;
import com.valunskii.foxminded.university.repository.entity.Parity;
import com.valunskii.foxminded.university.repository.entity.Schedule;
import com.valunskii.foxminded.university.repository.entity.Subject;
import com.valunskii.foxminded.university.repository.entity.Teacher;
import com.valunskii.foxminded.university.repository.executor.Executor;

public class ScheduleDao {
    private static Logger log = Logger.getLogger(ScheduleDao.class);
    private Executor executor = new Executor();

    public List<Schedule> get() throws SQLException {
        log.info("Looking for university schedule");
        return executor.execQuery(
                "  SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.name AS subject, teachers.teacher_id, teachers.first_name,"
                        + " teachers.middle_name, teachers.last_name, groups.name AS group_name, classrooms.name AS classroom"
                        + " FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                        + " JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                        + " JOIN subjects ON lectures.subject_id = subjects.subject_id"
                        + " JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                        + " JOIN groups ON lectures.group_id = groups.group_id"
                        + " JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id"
                        + " ORDER BY schedule.parity,schedule.day_of_week, schedule.lesson;",
                result -> {
                    List<Schedule> list = new ArrayList<>();
                    Schedule schedule = null;
                    Set<Lecture> lectures = new HashSet<>();
                    while (result.next()) {
                        if (schedule == null) {
                            schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                                    Parity.valueOf(result.getString("parity")),
                                    Lesson.valueOf(result.getString("lesson")));
                        }
                        if (!result.getString("day_of_week").equals(schedule.getDayOfWeek().toString())
                                || !result.getString("parity").equals(schedule.getParity().toString())
                                || !result.getString("lesson").equals(schedule.getLesson().toString())) {
                            schedule.setLectures(lectures);
                            list.add(schedule);
                            lectures = new HashSet<>();
                            schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                                    Parity.valueOf(result.getString("parity")),
                                    Lesson.valueOf(result.getString("lesson")));
                        }
                        Subject subject = new Subject(result.getString("subject"));
                        Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                                result.getString("middle_name"), result.getString("last_name"));
                        Group group = new Group(result.getString("group_name"));
                        Classroom classroom = new Classroom(result.getString("classroom"));
                        Lecture lecture = new Lecture(subject, teacher, group, classroom);
                        lectures.add(lecture);
                    }
                    schedule.setLectures(lectures);
                    list.add(schedule);
                    log.info("Return university schedule");
                    return list;
                });
    }

    public List<Schedule> getGroupSchedule(String groupName) throws SQLException {
        log.info("Looking for schedule for group: " + groupName);
        return executor.execQuery(
                "  SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.name AS subject, teachers.teacher_id, teachers.first_name,"
                        + " teachers.middle_name, teachers.last_name, groups.name AS group_name, classrooms.name AS classroom"
                        + " FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                        + " JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                        + " JOIN subjects ON lectures.subject_id = subjects.subject_id"
                        + " JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                        + " JOIN groups ON lectures.group_id = groups.group_id"
                        + " JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id"
                        + " WHERE groups.name = '" + groupName
                        + "' ORDER BY schedule.parity,schedule.day_of_week, schedule.lesson;",
                result -> {
                    List<Schedule> list = new ArrayList<>();
                    Schedule schedule = null;
                    Set<Lecture> lectures = new HashSet<>();
                    while (result.next()) {
                        if (schedule == null) {
                            schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                                    Parity.valueOf(result.getString("parity")),
                                    Lesson.valueOf(result.getString("lesson")));
                        }
                        if (!result.getString("day_of_week").equals(schedule.getDayOfWeek().toString())
                                || !result.getString("parity").equals(schedule.getParity().toString())
                                || !result.getString("lesson").equals(schedule.getLesson().toString())) {
                            schedule.setLectures(lectures);
                            list.add(schedule);
                            lectures = new HashSet<>();
                            schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                                    Parity.valueOf(result.getString("parity")),
                                    Lesson.valueOf(result.getString("lesson")));
                        }
                        Subject subject = new Subject(result.getString("subject"));
                        Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                                result.getString("middle_name"), result.getString("last_name"));
                        Group group = new Group(result.getString("group_name"));
                        Classroom classroom = new Classroom(result.getString("classroom"));
                        Lecture lecture = new Lecture(subject, teacher, group, classroom);
                        lectures.add(lecture);
                    }
                    schedule.setLectures(lectures);
                    list.add(schedule);
                    log.info("Return schedule for the group");
                    return list;
                });
    }

    public List<Schedule> getGroupDaySchedule(String groupName, DayOfWeek day, Parity parity) throws SQLException {
        log.info("Looking for schedule for group: " + groupName + ", day: " + day.toString() + " " + parity.toString());
        return executor.execQuery(
                "  SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.name AS subject, teachers.teacher_id, teachers.first_name,"
                        + " teachers.middle_name, teachers.last_name, groups.name AS group_name, classrooms.name AS classroom"
                        + " FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                        + " JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                        + " JOIN subjects ON lectures.subject_id = subjects.subject_id"
                        + " JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                        + " JOIN groups ON lectures.group_id = groups.group_id"
                        + " JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id"
                        + " WHERE groups.name = '" + groupName + "' AND schedule.day_of_week = '" + day.toString()
                        + "' AND schedule.parity = '" + parity.toString()
                        + "' ORDER BY schedule.parity,schedule.day_of_week, schedule.lesson;",
                result -> {
                    List<Schedule> list = new ArrayList<>();
                    Schedule schedule = null;
                    Set<Lecture> lectures = new HashSet<>();
                    while (result.next()) {
                        if (schedule == null) {
                            schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                                    Parity.valueOf(result.getString("parity")),
                                    Lesson.valueOf(result.getString("lesson")));
                        }
                        if (!result.getString("lesson").equals(schedule.getLesson().toString())) {
                            schedule.setLectures(lectures);
                            list.add(schedule);
                            lectures = new HashSet<>();
                            schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                                    Parity.valueOf(result.getString("parity")),
                                    Lesson.valueOf(result.getString("lesson")));
                        }
                        Subject subject = new Subject(result.getString("subject"));
                        Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                                result.getString("middle_name"), result.getString("last_name"));
                        Group group = new Group(result.getString("group_name"));
                        Classroom classroom = new Classroom(result.getString("classroom"));
                        Lecture lecture = new Lecture(subject, teacher, group, classroom);
                        lectures.add(lecture);
                    }
                    schedule.setLectures(lectures);
                    list.add(schedule);
                    log.info("Return day schedule for the group");
                    return list;
                });
    }

    public List<Schedule> getTeacherSchedule(int teacherId) throws SQLException {
        log.info("Looking for schedule for teacher with id: " + teacherId);
        return executor.execQuery(
                "  SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.name AS subject, teachers.teacher_id, teachers.first_name,"
                        + " teachers.middle_name, teachers.last_name, groups.name AS group_name, classrooms.name AS classroom"
                        + " FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                        + " JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                        + " JOIN subjects ON lectures.subject_id = subjects.subject_id"
                        + " JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                        + " JOIN groups ON lectures.group_id = groups.group_id"
                        + " JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id"
                        + " WHERE teachers.teacher_id = '" + teacherId
                        + "' ORDER BY schedule.parity,schedule.day_of_week, schedule.lesson;",
                result -> {
                    List<Schedule> list = new ArrayList<>();
                    Schedule schedule = null;
                    Set<Lecture> lectures = new HashSet<>();
                    while (result.next()) {
                        if (schedule == null) {
                            schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                                    Parity.valueOf(result.getString("parity")),
                                    Lesson.valueOf(result.getString("lesson")));
                        }
                        if (!result.getString("day_of_week").equals(schedule.getDayOfWeek().toString())
                                || !result.getString("parity").equals(schedule.getParity().toString())
                                || !result.getString("lesson").equals(schedule.getLesson().toString())) {
                            schedule.setLectures(lectures);
                            list.add(schedule);
                            lectures = new HashSet<>();
                            schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                                    Parity.valueOf(result.getString("parity")),
                                    Lesson.valueOf(result.getString("lesson")));
                        }
                        Subject subject = new Subject(result.getString("subject"));
                        Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                                result.getString("middle_name"), result.getString("last_name"));
                        Group group = new Group(result.getString("group_name"));
                        Classroom classroom = new Classroom(result.getString("classroom"));
                        Lecture lecture = new Lecture(subject, teacher, group, classroom);
                        lectures.add(lecture);
                    }
                    schedule.setLectures(lectures);
                    list.add(schedule);
                    log.info("Return schedule for the teacher");
                    return list;
                });
    }

    public List<Schedule> getTeacherDaySchedule(int teacherId, DayOfWeek day, Parity parity) throws SQLException {
        log.info("Looking for schedule for teacher with id: " + teacherId + ", day: " + day.toString() + " "
                + parity.toString());
        return executor.execQuery(
                "  SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.name AS subject, teachers.teacher_id, teachers.first_name,"
                        + " teachers.middle_name, teachers.last_name, groups.name AS group_name, classrooms.name AS classroom"
                        + " FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                        + " JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                        + " JOIN subjects ON lectures.subject_id = subjects.subject_id"
                        + " JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                        + " JOIN groups ON lectures.group_id = groups.group_id"
                        + " JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id"
                        + " WHERE teachers.teacher_id = '" + teacherId + "' AND schedule.day_of_week = '"
                        + day.toString() + "' AND schedule.parity = '" + parity.toString()
                        + "' ORDER BY schedule.parity,schedule.day_of_week, schedule.lesson;",
                result -> {
                    List<Schedule> list = new ArrayList<>();
                    Schedule schedule = null;
                    Set<Lecture> lectures = new HashSet<>();
                    while (result.next()) {
                        if (schedule == null) {
                            schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                                    Parity.valueOf(result.getString("parity")),
                                    Lesson.valueOf(result.getString("lesson")));
                        }
                        if (!result.getString("lesson").equals(schedule.getLesson().toString())) {
                            schedule.setLectures(lectures);
                            list.add(schedule);
                            lectures = new HashSet<>();
                            schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                                    Parity.valueOf(result.getString("parity")),
                                    Lesson.valueOf(result.getString("lesson")));
                        }
                        Subject subject = new Subject(result.getString("subject"));
                        Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                                result.getString("middle_name"), result.getString("last_name"));
                        Group group = new Group(result.getString("group_name"));
                        Classroom classroom = new Classroom(result.getString("classroom"));
                        Lecture lecture = new Lecture(subject, teacher, group, classroom);
                        lectures.add(lecture);
                    }
                    schedule.setLectures(lectures);
                    list.add(schedule);
                    log.info("Return day schedule for the teacher");
                    return list;
                });
    }
}
