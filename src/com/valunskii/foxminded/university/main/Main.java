package com.valunskii.foxminded.university.main;

import java.time.DayOfWeek;
import java.util.List;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Classroom;
import com.valunskii.foxminded.university.repository.entity.Group;
import com.valunskii.foxminded.university.repository.entity.Lecture;
import com.valunskii.foxminded.university.repository.entity.Parity;
import com.valunskii.foxminded.university.repository.entity.Schedule;
import com.valunskii.foxminded.university.repository.entity.Student;
import com.valunskii.foxminded.university.repository.entity.Subject;
import com.valunskii.foxminded.university.repository.entity.Teacher;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.ClassroomService;
import com.valunskii.foxminded.university.service.GroupService;
import com.valunskii.foxminded.university.service.ScheduleService;
import com.valunskii.foxminded.university.service.StudentService;
import com.valunskii.foxminded.university.service.SubjectService;
import com.valunskii.foxminded.university.service.TeacherService;

public class Main {
    final static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        log.info("START APPLICATION");

        showUniversity();
        showAllStudents();
        showAllTeachers();
        showUnivwrsityShedule();
        showGroupShedule("N-3147");
        showGroupDayShedule("N-3147", DayOfWeek.MONDAY, Parity.EVEN);
        showTeacherSchedule(1);
        showTeacherDaySchedule(1, DayOfWeek.MONDAY, Parity.EVEN);

    }

    private static void showUniversity() {
        System.out.println("1_Список всех групп в университете:");
        List<Group> groups = null;
        try {
            groups = GroupService.getAllGroups();
        } catch (DAOException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Group group : groups) {
            System.out.print(group.getName() + " ");
        }
        System.out.println("\t -всего " + groups.size());
        System.out.println();

        System.out.println("2_Список всех аудиторий университета:");
        List<Classroom> rooms = null;
        try {
            rooms = ClassroomService.getAllClassrooms();
        } catch (DAOException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Classroom room : rooms) {
            System.out.print(room.getName() + " ");
        }
        System.out.println("\t -всего " + rooms.size());
        System.out.println();

        System.out.println("3_Список всех предметов, изучаемых в университете:");
        List<Subject> subjects = null;
        try {
            subjects = SubjectService.getAllSubjects();
        } catch (DAOException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Subject subject : subjects) {
            System.out.println("    " + subject.getName() + " ");
        }
        System.out.println("\t -всего " + subjects.size());
        System.out.println();
    }

    private static void showAllTeachers() {
        System.out.println("Преподавательский состав университета:");
        List<Teacher> teachers = null;
        try {
            teachers = TeacherService.getAllTeachers();
        } catch (DAOException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Teacher teacher : teachers) {
            System.out.println("  (id = " + teacher.getId() + ") " + teacher.getLastName() + " "
                    + teacher.getFirstName() + " " + teacher.getMiddleName());
        }
        System.out.println("\t -всего " + teachers.size());
        System.out.println();
    }

    private static void showAllStudents() {
        System.out.println("Список всех учащихся в университете:");
        List<Student> students = null;
        try {
            students = StudentService.getAllStudents();
        } catch (DAOException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Student student : students) {
            System.out.println("  (id = " + student.getId() + ") " + student.getLastName() + " "
                    + student.getFirstName() + " " + student.getMiddleName());
        }
        System.out.println("\t -всего " + students.size());
        System.out.println();

        System.out.println("________");
        System.out.println();
    }

   
    public static void showUnivwrsityShedule() {
        System.out.println("Расписание университета ...");
        List<Schedule> schedule = null;

        try {
            schedule = ScheduleService.getAllSchedule();
            System.out.println(schedule.size());
        } catch (DAOException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Schedule row : schedule) {
            System.out.printf("%s %s %s: \n", row.getDayOfWeek(), row.getParity(), row.getLesson());
            for (Lecture lecture : row.getLectures()) {
                System.out.printf("%s  / %s  /  %s / %s \n", lecture.getSubject().getName(),
                        lecture.getTeacher().getLastName(), lecture.getGroup().getName(),
                        lecture.getClassroom().getName());
            }
            System.out.println();
        }
    }

// TODO make better appearance for schedule reports (if necessary)
    public static void showGroupShedule(String groupName) {
        System.out.println("Расписание занятий для группы " + groupName);
        List<Schedule> schedule = null;

        try {
            schedule = ScheduleService.getGroupSchedule(groupName);
            System.out.println(schedule.size());
        } catch (DAOException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Schedule row : schedule) {
            System.out.printf("%s %s %s: \n", row.getDayOfWeek(), row.getParity(), row.getLesson());
            for (Lecture lecture : row.getLectures()) {
                System.out.printf("%s  / %s  /  %s / %s \n", lecture.getSubject().getName(),
                        lecture.getTeacher().getLastName(), lecture.getGroup().getName(),
                        lecture.getClassroom().getName());
            }
            System.out.println();
        }
    }

    public static void showGroupDayShedule(String groupName, DayOfWeek day, Parity parity) {
        System.out.println("Расписание занятий для группы " + groupName);
        List<Schedule> schedule = null;

        try {
            schedule = ScheduleService.getGroupDaySchedule(groupName, day, parity);
            System.out.println(schedule.size());
        } catch (DAOException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Schedule row : schedule) {
            System.out.printf("%s %s %s: \n", row.getDayOfWeek(), row.getParity(), row.getLesson());
            for (Lecture lecture : row.getLectures()) {
                System.out.printf("%s  / %s  /  %s / %s \n", lecture.getSubject().getName(),
                        lecture.getTeacher().getLastName(), lecture.getGroup().getName(),
                        lecture.getClassroom().getName());
            }
            System.out.println();
        }
    }

    public static void showTeacherSchedule(int teacherId) {
        System.out.println("Расписание занятий для преподавателя с id = " + teacherId);
        List<Schedule> schedule = null;

        try {
            schedule = ScheduleService.getTacherSchedule(teacherId);
            System.out.println(schedule.size());
        } catch (DAOException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Schedule row : schedule) {
            System.out.printf("%s %s %s: \n", row.getDayOfWeek(), row.getParity(), row.getLesson());
            for (Lecture lecture : row.getLectures()) {
                System.out.printf("%s  / %s  /  %s / %s \n", lecture.getSubject().getName(),
                        lecture.getTeacher().getLastName(), lecture.getGroup().getName(),
                        lecture.getClassroom().getName());
            }
            System.out.println();
        }
    }

    public static void showTeacherDaySchedule(int teacherId, DayOfWeek day, Parity parity) {
        System.out.println("Расписание занятий для преподавателя с id = " + teacherId);
        List<Schedule> schedule = null;

        try {
            schedule = ScheduleService.getTeacherDaySchedule(teacherId, day, parity);
            System.out.println(schedule.size());
        } catch (DAOException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Schedule row : schedule) {
            System.out.printf("%s %s %s: \n", row.getDayOfWeek(), row.getParity(), row.getLesson());
            for (Lecture lecture : row.getLectures()) {
                System.out.printf("%s  / %s  /  %s / %s \n", lecture.getSubject().getName(),
                        lecture.getTeacher().getLastName(), lecture.getGroup().getName(),
                        lecture.getClassroom().getName());
            }
            System.out.println();
        }
    }
}
