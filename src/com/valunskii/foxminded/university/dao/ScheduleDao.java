package com.valunskii.foxminded.university.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.valunskii.foxminded.university.dao.executor.Executor;
import com.valunskii.foxminded.university.domain.Lecture;
import com.valunskii.foxminded.university.domain.Lesson;
import com.valunskii.foxminded.university.domain.Parity;
import com.valunskii.foxminded.university.domain.Schedule;

public class ScheduleDao {
    private Executor executor;

    public ScheduleDao() {
        this.executor = new Executor();
    }

    public List<Schedule> get() throws SQLException {
        return executor.execQuery(
                "SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.name AS subject, teachers.first_name,"
                        + "teachers.middle_name, teachers.last_name, groups.name AS group_name, classrooms.name AS classroom"
                        + "FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                        + "JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                        + "JOIN subjects ON lectures.subject_id = subjects.subject_id"
                        + "JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                        + "JOIN groups ON lectures.group_id = groups.group_id"
                        + "JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id"
                        + "ORDER BY schedule.parity,schedule.day_of_week, schedule.lesson;",
                result -> {
                    List<Schedule> list = new ArrayList<>();
                    while (result.next()) {
                        if (result.getString("day_of_week").equals("MONDAY")) {
                            DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
                        }
                        if (result.getString("day_of_week").equals("TUESDAY")) {
                            DayOfWeek dayOfWeek = DayOfWeek.TUESDAY;
                        }
                        if (result.getString("day_of_week").equals("WEDNESDAY")) {
                            DayOfWeek dayOfWeek = DayOfWeek.WEDNESDAY;
                        }
                        if (result.getString("day_of_week").equals("THURSDAY")) {
                            DayOfWeek dayOfWeek = DayOfWeek.THURSDAY;
                        }
                        if (result.getString("day_of_week").equals("FRIDAY")) {
                            DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
                        }
                        if (result.getString("day_of_week").equals("SATURDAY")) {
                            DayOfWeek dayOfWeek = DayOfWeek.SATURDAY;
                        }
                        if (result.getString("parity").equals("ODD")) {
                            Parity parity = Parity.ODD;
                        }
                        if (result.getString("parity").equals("EVEN")) {
                            Parity parity = Parity.EVEN;
                        }
                        if (result.getString("lesson").equals("FIRST")) {
                            Lesson lesson = Lesson.FIRST;
                        }
                        if (result.getString("lesson").equals("SECOND")) {
                            Lesson lesson = Lesson.SECOND;
                        }
                        if (result.getString("lesson").equals("THIRD")) {
                            Lesson lesson = Lesson.THIRD;
                        }
                        if (result.getString("lesson").equals("FOURTH")) {
                            Lesson lesson = Lesson.FOURTH;
                        }
                        if (result.getString("lesson").equals("FIFTH")) {
                            Lesson lesson = Lesson.FIFTH;
                        }
                        if (result.getString("lesson").equals("SIXTH")) {
                            Lesson lesson = Lesson.SIXTH;
                        }
                        
                        Schedule s = new Schedule(dayOfWeek, parity, lesson, lectures);

                    }
                    return list;
                });
    }
}

//new Student(result.getInt("student_id"), result.getString("first_name"), result.getString("middle_name"), result.getString("last_name"));