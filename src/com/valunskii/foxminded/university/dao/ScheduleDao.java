package com.valunskii.foxminded.university.dao;

import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.valunskii.foxminded.university.dao.executor.Executor;
import com.valunskii.foxminded.university.domain.Classroom;
import com.valunskii.foxminded.university.domain.Group;
import com.valunskii.foxminded.university.domain.Lecture;
import com.valunskii.foxminded.university.domain.Lesson;
import com.valunskii.foxminded.university.domain.Parity;
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
                    Set<Lecture> lectures = new HashSet<>();
                    while (result.next()) {
                        if (!result.getString("day_of_week").equals(schedule.getDayOfWeek())
                                || !result.getString("parity").equals(schedule.getParity())
                                || !result.getString("lesson").equals(schedule.getLesson())) {
                            schedule.setLectures(lectures);
                            lectures = new HashSet<>();
                            schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")), Parity.valueOf(result.getString("parity")),
                                    Lesson.valueOf(result.getString("lesson")));
                            list.add(schedule);
                        }
                        Subject subject = new Subject(result.getString("subject"));
                        Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                                result.getString("middle_name"), result.getString("last_name"));
                        Group group = new Group(result.getString("group_name"));
                        Classroom classroom = new Classroom(result.getString("classroom"));

                        Lecture lecture = new Lecture(subject, teacher, group, classroom);
                        lectures.add(lecture);
                        

                    }
                    return list;
                });
    }
}
