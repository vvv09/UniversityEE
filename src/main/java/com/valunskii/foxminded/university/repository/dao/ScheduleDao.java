package com.valunskii.foxminded.university.repository.dao;

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
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.repository.executor.Executor;

public class ScheduleDao {
    private static Logger log = Logger.getLogger(ScheduleDao.class);
    private Executor executor = new Executor();

    public List<Schedule> get() throws DAOException {
        log.info("Looking for university schedule");
        return executor.execQuery(result -> {
            List<Schedule> list = new ArrayList<>();
            Schedule schedule = null;
            Set<Lecture> lectures = new HashSet<>();
            while (result.next()) {
                if (schedule == null) {
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                if (!result.getString("day_of_week").equals(schedule.getDayOfWeek().toString())
                        | !result.getString("parity").equals(schedule.getParity().toString())
                        | !result.getString("lesson").equals(schedule.getLesson().toString())) {
                    schedule.setLectures(lectures);
                    list.add(schedule);
                    lectures = new HashSet<>();
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                Subject subject = new Subject(result.getInt("subject_id"), result.getString("subject"));
                Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                        result.getString("middle_name"), result.getString("last_name"));
                Group group = new Group(result.getInt("group_id"), result.getString("group_name"));
                Classroom classroom = new Classroom(result.getInt("classroom_id"), result.getString("classroom"));
                Lecture lecture = new Lecture(subject, teacher, group, classroom);
                lectures.add(lecture);
            }
            schedule.setLectures(lectures);
            list.add(schedule);
            log.info("Return university schedule");
            return list;
        }, "SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.subject_id, subjects.name AS subject, teachers.teacher_id, teachers.first_name,"
                + " teachers.middle_name, teachers.last_name, groups.group_id, groups.name AS group_name, classrooms.classroom_id, classrooms.name AS classroom"
                + " FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                + " JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                + " JOIN subjects ON lectures.subject_id = subjects.subject_id"
                + " JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                + " JOIN groups ON lectures.group_id = groups.group_id"
                + " JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id"
                + " ORDER BY schedule.parity,schedule.day_of_week, schedule.lesson;");
    }

    public List<Schedule> getGroupSchedule(int groupId) throws DAOException {
        log.info("Looking for schedule for group with id = : " + groupId);
        return executor.execQuery(result -> {
            List<Schedule> list = new ArrayList<>();
            Schedule schedule = null;
            Set<Lecture> lectures = new HashSet<>();
            while (result.next()) {
                if (schedule == null) {
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                if (!result.getString("day_of_week").equals(schedule.getDayOfWeek().toString())
                        | !result.getString("parity").equals(schedule.getParity().toString())
                        | !result.getString("lesson").equals(schedule.getLesson().toString())) {
                    schedule.setLectures(lectures);
                    list.add(schedule);
                    lectures = new HashSet<>();
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                Subject subject = new Subject(result.getInt("subject_id"), result.getString("subject"));
                Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                        result.getString("middle_name"), result.getString("last_name"));
                Group group = new Group(result.getInt("group_id"), result.getString("group_name"));
                Classroom classroom = new Classroom(result.getInt("classroom_id"), result.getString("classroom"));
                Lecture lecture = new Lecture(subject, teacher, group, classroom);
                lectures.add(lecture);
            }
            schedule.setLectures(lectures);
            list.add(schedule);
            log.info("Return schedule for the group");
            return list;
        }, "SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.subject_id, subjects.name AS subject, teachers.teacher_id, teachers.first_name,"
                + " teachers.middle_name, teachers.last_name, groups.group_id, groups.name AS group_name, classrooms.classroom_id, classrooms.name AS classroom"
                + " FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                + " JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                + " JOIN subjects ON lectures.subject_id = subjects.subject_id"
                + " JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                + " JOIN groups ON lectures.group_id = groups.group_id"
                + " JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id" + " WHERE groups.group_id = ?"
                + " ORDER BY schedule.parity,schedule.day_of_week, schedule.lesson;", groupId);
    }

    public List<Schedule> getGroupDaySchedule(int groupId, DayOfWeek day, Parity parity) throws DAOException {
        log.info("Looking for schedule for group with id = " + groupId + ", day: " + day.name() + " " + parity.name());
        return executor.execQuery(result -> {
            List<Schedule> list = new ArrayList<>();
            Schedule schedule = null;
            Set<Lecture> lectures = new HashSet<>();
            while (result.next()) {
                if (schedule == null) {
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                if (!result.getString("day_of_week").equals(schedule.getDayOfWeek().toString())
                        | !result.getString("parity").equals(schedule.getParity().toString())
                        | !result.getString("lesson").equals(schedule.getLesson().toString())) {
                    schedule.setLectures(lectures);
                    list.add(schedule);
                    lectures = new HashSet<>();
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                Subject subject = new Subject(result.getInt("subject_id"), result.getString("subject"));
                Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                        result.getString("middle_name"), result.getString("last_name"));
                Group group = new Group(result.getInt("group_id"), result.getString("group_name"));
                Classroom classroom = new Classroom(result.getInt("classroom_id"), result.getString("classroom"));
                Lecture lecture = new Lecture(subject, teacher, group, classroom);
                lectures.add(lecture);
            }
            schedule.setLectures(lectures);
            list.add(schedule);
            log.info("Return day schedule for the group");
            return list;
        }, "SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.subject_id, subjects.name AS subject, teachers.teacher_id, teachers.first_name,"
                + " teachers.middle_name, teachers.last_name, groups.group_id, groups.name AS group_name, classrooms.classroom_id, classrooms.name AS classroom"
                + " FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                + " JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                + " JOIN subjects ON lectures.subject_id = subjects.subject_id"
                + " JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                + " JOIN groups ON lectures.group_id = groups.group_id"
                + " JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id"
                + " WHERE groups.group_id = ? AND schedule.day_of_week = CAST ( ? AS day_of_week) AND schedule.parity = CAST (? As parity)"
                + " ORDER BY schedule.parity, schedule.day_of_week, schedule.lesson;", groupId, day.name(),
                parity.name());
    }
    
    public List<Schedule> getGroupDayScheduleExceptParty(int groupId, DayOfWeek day) throws DAOException {
        log.info("Looking for schedule for group with id = " + groupId + ", day: " + day.name());
        return executor.execQuery(result -> {
            List<Schedule> list = new ArrayList<>();
            Schedule schedule = null;
            Set<Lecture> lectures = new HashSet<>();
            while (result.next()) {
                if (schedule == null) {
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                if (!result.getString("day_of_week").equals(schedule.getDayOfWeek().toString())
                        | !result.getString("parity").equals(schedule.getParity().toString())
                        | !result.getString("lesson").equals(schedule.getLesson().toString())) {
                    schedule.setLectures(lectures);
                    list.add(schedule);
                    lectures = new HashSet<>();
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                Subject subject = new Subject(result.getInt("subject_id"), result.getString("subject"));
                Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                        result.getString("middle_name"), result.getString("last_name"));
                Group group = new Group(result.getInt("group_id"), result.getString("group_name"));
                Classroom classroom = new Classroom(result.getInt("classroom_id"), result.getString("classroom"));
                Lecture lecture = new Lecture(subject, teacher, group, classroom);
                lectures.add(lecture);
            }
            schedule.setLectures(lectures);
            list.add(schedule);
            log.info("Return day schedule for the group");
            return list;
        }, "SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.subject_id, subjects.name AS subject, teachers.teacher_id, teachers.first_name,"
                + " teachers.middle_name, teachers.last_name, groups.group_id, groups.name AS group_name, classrooms.classroom_id, classrooms.name AS classroom"
                + " FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                + " JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                + " JOIN subjects ON lectures.subject_id = subjects.subject_id"
                + " JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                + " JOIN groups ON lectures.group_id = groups.group_id"
                + " JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id"
                + " WHERE groups.group_id = ? AND schedule.day_of_week = CAST ( ? AS day_of_week) "
                + " ORDER BY schedule.parity, schedule.day_of_week, schedule.lesson;", groupId, day.name());
    }
    
    public List<Schedule> getGroupDayScheduleExceptDay(int groupId, Parity parity) throws DAOException {
        log.info("Looking for schedule for group with id =  " + groupId + ", parity: " + parity.name());
        return executor.execQuery(result -> {
            List<Schedule> list = new ArrayList<>();
            Schedule schedule = null;
            Set<Lecture> lectures = new HashSet<>();
            while (result.next()) {
                if (schedule == null) {
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                if (!result.getString("day_of_week").equals(schedule.getDayOfWeek().toString())
                        | !result.getString("parity").equals(schedule.getParity().toString())
                        | !result.getString("lesson").equals(schedule.getLesson().toString())) {
                    schedule.setLectures(lectures);
                    list.add(schedule);
                    lectures = new HashSet<>();
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                Subject subject = new Subject(result.getInt("subject_id"), result.getString("subject"));
                Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                        result.getString("middle_name"), result.getString("last_name"));
                Group group = new Group(result.getInt("group_id"), result.getString("group_name"));
                Classroom classroom = new Classroom(result.getInt("classroom_id"), result.getString("classroom"));
                Lecture lecture = new Lecture(subject, teacher, group, classroom);
                lectures.add(lecture);
            }
            schedule.setLectures(lectures);
            list.add(schedule);
            log.info("Return day schedule for the group");
            return list;
        }, "SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.subject_id, subjects.name AS subject, teachers.teacher_id, teachers.first_name,"
                + " teachers.middle_name, teachers.last_name, groups.group_id, groups.name AS group_name, classrooms.classroom_id, classrooms.name AS classroom"
                + " FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                + " JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                + " JOIN subjects ON lectures.subject_id = subjects.subject_id"
                + " JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                + " JOIN groups ON lectures.group_id = groups.group_id"
                + " JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id"
                + " WHERE groups.group_id = ? AND schedule.parity = CAST (? As parity)"
                + " ORDER BY schedule.parity, schedule.day_of_week, schedule.lesson;", groupId, parity.name());
    }

    public List<Schedule> getTeacherSchedule(int teacherId) throws DAOException {
        log.info("Looking for schedule for teacher with id: " + teacherId);
        return executor.execQuery(result -> {
            List<Schedule> list = new ArrayList<>();
            Schedule schedule = null;
            Set<Lecture> lectures = new HashSet<>();
            while (result.next()) {
                if (schedule == null) {
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                if (!result.getString("day_of_week").equals(schedule.getDayOfWeek().toString())
                        | !result.getString("parity").equals(schedule.getParity().toString())
                        | !result.getString("lesson").equals(schedule.getLesson().toString())) {
                    schedule.setLectures(lectures);
                    list.add(schedule);
                    lectures = new HashSet<>();
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                Subject subject = new Subject(result.getInt("subject_id"), result.getString("subject"));
                Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                        result.getString("middle_name"), result.getString("last_name"));
                Group group = new Group(result.getInt("group_id"), result.getString("group_name"));
                Classroom classroom = new Classroom(result.getInt("classroom_id"), result.getString("classroom"));
                Lecture lecture = new Lecture(subject, teacher, group, classroom);
                lectures.add(lecture);
            }
            schedule.setLectures(lectures);
            list.add(schedule);
            log.info("Return schedule for the teacher");
            return list;
        }, "SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.subject_id, subjects.name AS subject, teachers.teacher_id, teachers.first_name,"
                + " teachers.middle_name, teachers.last_name, groups.group_id, groups.name AS group_name, classrooms.classroom_id, classrooms.name AS classroom"
                + " FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                + " JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                + " JOIN subjects ON lectures.subject_id = subjects.subject_id"
                + " JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                + " JOIN groups ON lectures.group_id = groups.group_id"
                + " JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id"
                + " WHERE teachers.teacher_id = ? ORDER BY schedule.parity,schedule.day_of_week, schedule.lesson;",
                teacherId);
    }

    public List<Schedule> getTeacherDaySchedule(int teacherId, DayOfWeek day, Parity parity) throws DAOException {
        log.info("Looking for schedule for teacher with id: " + teacherId + ", day: " + day.name() + " "
                + parity.name());
        return executor.execQuery(result -> {
            List<Schedule> list = new ArrayList<>();
            Schedule schedule = null;
            Set<Lecture> lectures = new HashSet<>();
            while (result.next()) {
                if (schedule == null) {
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                if (!result.getString("day_of_week").equals(schedule.getDayOfWeek().toString())
                        | !result.getString("parity").equals(schedule.getParity().toString())
                        | !result.getString("lesson").equals(schedule.getLesson().toString())) {
                    schedule.setLectures(lectures);
                    list.add(schedule);
                    lectures = new HashSet<>();
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                Subject subject = new Subject(result.getInt("subject_id"), result.getString("subject"));
                Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                        result.getString("middle_name"), result.getString("last_name"));
                Group group = new Group(result.getInt("group_id"), result.getString("group_name"));
                Classroom classroom = new Classroom(result.getInt("classroom_id"), result.getString("classroom"));
                Lecture lecture = new Lecture(subject, teacher, group, classroom);
                lectures.add(lecture);
            }
            schedule.setLectures(lectures);
            list.add(schedule);
            log.info("Return day schedule for the teacher");
            return list;
        }, "SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.subject_id, subjects.name AS subject, teachers.teacher_id, teachers.first_name,"
                + " teachers.middle_name, teachers.last_name, groups.group_id, groups.name AS group_name, classrooms.classroom_id, classrooms.name AS classroom"
                + " FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                + " JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                + " JOIN subjects ON lectures.subject_id = subjects.subject_id"
                + " JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                + " JOIN groups ON lectures.group_id = groups.group_id"
                + " JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id"
                + " WHERE teachers.teacher_id = ? AND schedule.day_of_week = CAST ( ? AS day_of_week) AND schedule.parity = CAST (? As parity) "
                + "ORDER BY schedule.parity,schedule.day_of_week, schedule.lesson;", teacherId, day.name(),
                parity.name());
    }
    
    public List<Schedule> getTeacherDayScheduleExceptDay(int teacherId, Parity parity) throws DAOException {
        log.info("Looking for schedule for teacher with id: " + teacherId + ", parity: " + parity.name());
        return executor.execQuery(result -> {
            List<Schedule> list = new ArrayList<>();
            Schedule schedule = null;
            Set<Lecture> lectures = new HashSet<>();
            while (result.next()) {
                if (schedule == null) {
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                if (!result.getString("day_of_week").equals(schedule.getDayOfWeek().toString())
                        | !result.getString("parity").equals(schedule.getParity().toString())
                        | !result.getString("lesson").equals(schedule.getLesson().toString())) {
                    schedule.setLectures(lectures);
                    list.add(schedule);
                    lectures = new HashSet<>();
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                Subject subject = new Subject(result.getInt("subject_id"), result.getString("subject"));
                Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                        result.getString("middle_name"), result.getString("last_name"));
                Group group = new Group(result.getInt("group_id"), result.getString("group_name"));
                Classroom classroom = new Classroom(result.getInt("classroom_id"), result.getString("classroom"));
                Lecture lecture = new Lecture(subject, teacher, group, classroom);
                lectures.add(lecture);
            }
            schedule.setLectures(lectures);
            list.add(schedule);
            log.info("Return day schedule for the teacher");
            return list;
        }, "SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.subject_id, subjects.name AS subject, teachers.teacher_id, teachers.first_name,"
                + " teachers.middle_name, teachers.last_name, groups.group_id, groups.name AS group_name, classrooms.classroom_id, classrooms.name AS classroom"
                + " FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                + " JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                + " JOIN subjects ON lectures.subject_id = subjects.subject_id"
                + " JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                + " JOIN groups ON lectures.group_id = groups.group_id"
                + " JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id"
                + " WHERE teachers.teacher_id = ? AND schedule.parity = CAST (? As parity) "
                + "ORDER BY schedule.parity,schedule.day_of_week, schedule.lesson;", teacherId, parity.name());
    }
    
    public List<Schedule> getTeacherDayScheduleExceptParity(int teacherId, DayOfWeek day) throws DAOException {
        log.info("Looking for schedule for teacher with id: " + teacherId + ", day: " + day.name());
        return executor.execQuery(result -> {
            List<Schedule> list = new ArrayList<>();
            Schedule schedule = null;
            Set<Lecture> lectures = new HashSet<>();
            while (result.next()) {
                if (schedule == null) {
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                if (!result.getString("day_of_week").equals(schedule.getDayOfWeek().toString())
                        | !result.getString("parity").equals(schedule.getParity().toString())
                        | !result.getString("lesson").equals(schedule.getLesson().toString())) {
                    schedule.setLectures(lectures);
                    list.add(schedule);
                    lectures = new HashSet<>();
                    schedule = new Schedule(DayOfWeek.valueOf(result.getString("day_of_week")),
                            Parity.valueOf(result.getString("parity")), Lesson.valueOf(result.getString("lesson")));
                }
                Subject subject = new Subject(result.getInt("subject_id"), result.getString("subject"));
                Teacher teacher = new Teacher(result.getInt("teacher_id"), result.getString("first_name"),
                        result.getString("middle_name"), result.getString("last_name"));
                Group group = new Group(result.getInt("group_id"), result.getString("group_name"));
                Classroom classroom = new Classroom(result.getInt("classroom_id"), result.getString("classroom"));
                Lecture lecture = new Lecture(subject, teacher, group, classroom);
                lectures.add(lecture);
            }
            schedule.setLectures(lectures);
            list.add(schedule);
            log.info("Return day schedule for the teacher");
            return list;
        }, "SELECT schedule.day_of_week, schedule.parity, schedule.lesson, subjects.subject_id, subjects.name AS subject, teachers.teacher_id, teachers.first_name,"
                + " teachers.middle_name, teachers.last_name, groups.group_id, groups.name AS group_name, classrooms.classroom_id, classrooms.name AS classroom"
                + " FROM schedule JOIN lectures_sets_lectures ON lectures_sets_lectures.lectures_set_id = schedule.lecture_set_id"
                + " JOIN lectures ON lectures_sets_lectures.lecture_id = lectures.lecture_id"
                + " JOIN subjects ON lectures.subject_id = subjects.subject_id"
                + " JOIN teachers ON lectures.teacher_id = teachers.teacher_id"
                + " JOIN groups ON lectures.group_id = groups.group_id"
                + " JOIN classrooms ON lectures.classroom_id = classrooms.classroom_id"
                + " WHERE teachers.teacher_id = ? AND schedule.day_of_week = CAST ( ? AS day_of_week) "
                + "ORDER BY schedule.parity,schedule.day_of_week, schedule.lesson;", teacherId, day.name());
    }
}

