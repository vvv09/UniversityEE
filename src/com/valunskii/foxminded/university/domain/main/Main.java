package com.valunskii.foxminded.university.domain.main;

import java.time.DayOfWeek;
import java.util.List;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.dao.ClassroomService;
import com.valunskii.foxminded.university.dao.DBException;
import com.valunskii.foxminded.university.dao.GroupService;
import com.valunskii.foxminded.university.dao.ScheduleService;
import com.valunskii.foxminded.university.dao.StudentService;
import com.valunskii.foxminded.university.dao.SubjectService;
import com.valunskii.foxminded.university.dao.TeacherService;
import com.valunskii.foxminded.university.domain.Classroom;
import com.valunskii.foxminded.university.domain.Group;
import com.valunskii.foxminded.university.domain.Lecture;
import com.valunskii.foxminded.university.domain.Parity;
import com.valunskii.foxminded.university.domain.Schedule;
import com.valunskii.foxminded.university.domain.Student;
import com.valunskii.foxminded.university.domain.Subject;
import com.valunskii.foxminded.university.domain.Teacher;

public class Main {
    final static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        
        log.info("START APPLICATION");

//        showUniversity();
//        workWithStudents();
//        workWithTeachers();
        schowUnivwrsityShedule();
        schowGroupShedule("N-3147");
        schowGroupDayShedule("N-3147", DayOfWeek.MONDAY, Parity.EVEN);
        schowTeacherSchedule(1);
        schowTeacherDaySchedule(1, DayOfWeek.MONDAY, Parity.EVEN);


    }

    private static void showUniversity() {
        System.out.println("1_Список всех групп в университете:");
        List<Group> groups = null;
        try {
            groups = GroupService.getAllGroups();
        } catch (DBException e) {
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
        } catch (DBException e) {
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
        } catch (DBException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Subject subject : subjects) {
            System.out.println("    " + subject.getName() + " ");
        }
        System.out.println("\t -всего " + subjects.size());
        System.out.println();

        System.out.println("4_Преподавательский состав университета:");
        List<Teacher> teachers = null;
        try {
            teachers = TeacherService.getAllTeachers();
        } catch (DBException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Teacher teacher : teachers) {
            System.out.println("  (id = " + teacher.getId() + ") " + teacher.getLastName() + " "
                    + teacher.getFirstName() + " " + teacher.getMiddleName());
        }
        System.out.println("\t -всего " + teachers.size());
        System.out.println();

        System.out.println("5_Список всех учащихся в университете:");
        List<Student> students = null;
        try {
            students = StudentService.getAllStudents();
        } catch (DBException e) {
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

    // TODO working with list size as id looks like a bad idea. consider this...
    private static void workWithStudents() {
        System.out.println("Зачиляем нового студента ...");
        int studentsCount = 0;
        try {
            studentsCount = StudentService.addStudent("Моше", "Евкакиевич", "Попхадзе");
            System.out.println("Новый студент успешно добавлен!\nКоличество студентов: " + studentsCount);
        } catch (DBException e) {
            e.printStackTrace();
            log.error(e);
        }

        System.out.println("---");

        System.out.println("Ищем последнего зачисленного студента...");
        Student student = null;
        try {
            student = StudentService.getStudent(studentsCount);
        } catch (DBException e) {
            e.printStackTrace();
        }
        System.out.println("  (id = " + student.getId() + ") " + student.getLastName() + " " + student.getFirstName()
                + " " + student.getMiddleName());

        System.out.println("---");

        System.out.println("Отчисляем студента с id = 22 ...");
        try {
            studentsCount = StudentService.deleteStudent(22);
            System.out.println("Студент отчислен!\nКоличество студентов: " + studentsCount);
        } catch (DBException e) {
            e.printStackTrace();
            log.error(e);
        }
    }

    private static void workWithTeachers() {
        System.out.println("Нанимаем нового преподавателя ...");
        int teacherCount = 0;
        try {
            teacherCount = TeacherService.addTeacher("Моше", "Евкакиевич", "Попхадзе");
            System.out.println("Новый преподаватель успешно добавлен!\nКоличество преподавателей: " + teacherCount);
        } catch (DBException e) {
            e.printStackTrace();
        }

        System.out.println("---");

        System.out.println("Ищем последнего нанятого преподавателя...");
        Teacher teacher = null;
        try {
            teacher = TeacherService.getTeacher(teacherCount);
        } catch (DBException e) {
            e.printStackTrace();
            log.error(e);
        }
        System.out.println("  (id = " + teacher.getId() + ") " + teacher.getLastName() + " " + teacher.getFirstName()
                + " " + teacher.getMiddleName());

        System.out.println("---");

        System.out.println("Увольняем последнего нанятого преподавателя...");
        try {
            teacherCount = TeacherService.deleteTeacher(teacherCount);
            System.out.println("Преподаватель уволен!\nКоличество преподавателей: " + teacherCount);
        } catch (DBException e) {
            e.printStackTrace();
            log.error(e);
        }
    }

    public static void schowUnivwrsityShedule() {
        System.out.println("Расписание университета ...");
        List<Schedule> schedule = null;

        try {
            schedule = ScheduleService.getAllSchedule();
            System.out.println(schedule.size());
        } catch (DBException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Schedule row : schedule) {
            System.out.print(row.getDayOfWeek() + " " + row.getParity() + " " + row.getLesson() + ": \n");
            for (Lecture lecture : row.getLectures()) {
                System.out.println(lecture.getSubject().getName() + " / " + lecture.getTeacher().getLastName() + " / "
                        + lecture.getGroup().getName() + " / " + lecture.getClassroom().getName());
            }
            System.out.println();
        }
    }
// TODO make better appearance for schedule reports (if necessary)
    public static void schowGroupShedule(String groupName) {
        System.out.println("Расписание занятий для группы " + groupName);
        List<Schedule> schedule = null;

        try {
            schedule = ScheduleService.getGroupSchedule(groupName);
            System.out.println(schedule.size());
        } catch (DBException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Schedule row : schedule) {
            System.out.print(row.getDayOfWeek() + " " + row.getParity() + " " + row.getLesson() + ": \n");
            for (Lecture lecture : row.getLectures()) {
                System.out.println(lecture.getSubject().getName() + " / " + lecture.getTeacher().getLastName() + " / "
                        + lecture.getGroup().getName() + " / " + lecture.getClassroom().getName());
            }
            System.out.println();
        }
    }
    
    public static void schowGroupDayShedule(String groupName, DayOfWeek day, Parity parity) {
        System.out.println("Расписание занятий для группы " + groupName);
        List<Schedule> schedule = null;

        try {
            schedule = ScheduleService.getGroupDaySchedule(groupName, day, parity);
            System.out.println(schedule.size());
        } catch (DBException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Schedule row : schedule) {
            System.out.print(row.getDayOfWeek() + " " + row.getParity() + " " + row.getLesson() + ": \n");
            for (Lecture lecture : row.getLectures()) {
                System.out.println(lecture.getSubject().getName() + " / " + lecture.getTeacher().getLastName() + " / "
                        + lecture.getGroup().getName() + " / " + lecture.getClassroom().getName());
            }
            System.out.println();
        }
    }
    
    public static void schowTeacherSchedule(int teacherId) {
        System.out.println("Расписание занятий для преподавателя с id = " + teacherId);
        List<Schedule> schedule = null;

        try {
            schedule = ScheduleService.getTacherSchedule(teacherId);
            System.out.println(schedule.size());
        } catch (DBException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Schedule row : schedule) {
            System.out.print(row.getDayOfWeek() + " " + row.getParity() + " " + row.getLesson() + ": \n");
            for (Lecture lecture : row.getLectures()) {
                System.out.println(lecture.getSubject().getName() + " / " + lecture.getTeacher().getLastName() + " / "
                        + lecture.getGroup().getName() + " / " + lecture.getClassroom().getName());
            }
            System.out.println();
        }
    }
    
    public static void schowTeacherDaySchedule(int teacherId, DayOfWeek day, Parity parity) {
        System.out.println("Расписание занятий для преподавателя с id = " + teacherId);
        List<Schedule> schedule = null;

        try {
            schedule = ScheduleService.getTeacherDaySchedule(teacherId, day, parity);
            System.out.println(schedule.size());
        } catch (DBException e) {
            e.printStackTrace();
            log.error(e);
        }
        for (Schedule row : schedule) {
            System.out.print(row.getDayOfWeek() + " " + row.getParity() + " " + row.getLesson() + ": \n");
            for (Lecture lecture : row.getLectures()) {
                System.out.println(lecture.getSubject().getName() + " / " + lecture.getTeacher().getLastName() + " / "
                        + lecture.getGroup().getName() + " / " + lecture.getClassroom().getName());
            }
            System.out.println();
        }
    }
}
