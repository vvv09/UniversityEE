package com.valunskii.foxminded.university.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.valunskii.foxminded.university.dao.executor.Executor;
import com.valunskii.foxminded.university.domain.Classroom;
import com.valunskii.foxminded.university.domain.Group;
import com.valunskii.foxminded.university.domain.Lecture;
import com.valunskii.foxminded.university.domain.Schedule;
import com.valunskii.foxminded.university.domain.Subject;
import com.valunskii.foxminded.university.domain.Teacher;

public class ScheduleDao {
    private Executor executor;

    public ScheduleDao() {
        this.executor = new Executor();
    }

    public List<Schedule> get() throws SQLException {
        return executor.execQuery(
                "  SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.name AS subject, teachers.teacher_id, teachers.first_name,\r\n" + 
                "                        teachers.middle_name, teachers.last_name, groups.name AS group_name, classrooms.name AS classroom\r\n" + 
                "                        FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id\r\n" + 
                "                        JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id\r\n" + 
                "                        JOIN subjects ON lectures.subject_id = subjects.subject_id\r\n" + 
                "                        JOIN teachers ON lectures.teacher_id = teachers.teacher_id\r\n" + 
                "                        JOIN groups ON lectures.group_id = groups.group_id\r\n" + 
                "                        JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id\r\n" + 
                "                        ORDER BY schedule.parity,schedule.day_of_week, schedule.lesson;",
                result -> {
                    List<Schedule> list = new ArrayList<>();
                    Schedule schedule = new Schedule();
                    Set<Lecture> l = new HashSet<>();
                    while (result.next()) {
                        if (!result.getString("day_of_week").equals(schedule.getDayOfWeek())
                                || !result.getString("parity").equals(schedule.getParity())
                                || !result.getString("lesson").equals(schedule.getLesson())) {
                            schedule.setLectures(l);
                            l = new HashSet<>();
                            schedule = new Schedule(result.getString("day_of_week"), result.getString("parity"),
                                    result.getString("lesson"));
                            list.add(schedule);
                        }
                        Subject s = new Subject(result.getString("subject"));
                        Teacher t = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                                result.getString("middle_name"), result.getString("last_name"));
                        Group g = new Group(result.getString("group_name"));
                        Classroom c = new Classroom(result.getString("classroom"));

                        Lecture lecture = new Lecture(s, t, g, c);
                        l.add(lecture);
                        

                    }
                    return list;
                });
    }
}

//new Student(result.getInt("student_id"), result.getString("first_name"), result.getString("middle_name"), result.getString("last_name"));