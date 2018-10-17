package com.valunskii.foxminded.university.domain.main;

import java.util.List;

import com.valunskii.foxminded.university.dao.DBException;
import com.valunskii.foxminded.university.dao.DBService;
import com.valunskii.foxminded.university.domain.Classroom;
import com.valunskii.foxminded.university.domain.Group;
import com.valunskii.foxminded.university.domain.Lecture;
import com.valunskii.foxminded.university.domain.Schedule;
import com.valunskii.foxminded.university.domain.Student;
import com.valunskii.foxminded.university.domain.Subject;
import com.valunskii.foxminded.university.domain.Teacher;

public class Main {
    static DBService dbService = new DBService();
        
    public static void main(String[] args) {
             
//        showUniversity();
//        workWithStudents();
//        workWithTeachers();
        schowUnivwrsityShedule();
    }
    
    private static void showUniversity() {
        System.out.println("1_Список всех групп в университете:");
        List<Group> groups = null;
        try {
            groups = dbService.getAllGroups();
        } catch (DBException e) {
            e.printStackTrace();
        }
        for (Group group : groups) {
            System.out.print(group.getName() + " ");
        }
        System.out.println("\t -всего " + groups.size());
        System.out.println();

        System.out.println("2_Список всех аудиторий университета:");
        List<Classroom> rooms = null;
        try {
            rooms = dbService.getAllClassrooms();
        } catch (DBException e) {
            e.printStackTrace();
        }
        for (Classroom room : rooms) {
            System.out.print(room.getName() + " ");
        }
        System.out.println("\t -всего " + rooms.size());
        System.out.println();

        System.out.println("3_Список всех предметов, изучаемых в университете:");
        List<Subject> subjects = null;
        try {
            subjects = dbService.getAllSubjects();
        } catch (DBException e) {
            e.printStackTrace();
        }
        for (Subject subject : subjects) {
            System.out.println("    " + subject.getName() + " ");
        }
        System.out.println("\t -всего " + subjects.size());
        System.out.println();

        System.out.println("4_Преподавательский состав университета:");
        List<Teacher> teachers = null;
        try {
            teachers = dbService.getAllTeachers();
        } catch (DBException e) {
            e.printStackTrace();
        }
        for (Teacher teacher : teachers) {
            System.out.println("  (id = " + teacher.getId() + ") " + teacher.getLastName() + " "
                    + teacher.getFirstName() + " " + teacher.getMiddleName());
        }
        System.out.println("\t -всего " + teachers.size());
        System.out.println();

        System.out.println("5_Список всех учаащихся в университете:");
        List<Student> students = null;
        try {
            students = dbService.getAllStudents();
        } catch (DBException e) {
            e.printStackTrace();
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
    //TODO working with list size as id looks like a bad idea. consider this...
    private static void workWithStudents() {
        System.out.println("Зачиляем нового студента ...");
        int studentsCount = 0;
        try {
            studentsCount = dbService.addStudent("Моше", "Евкакиевич", "Попхадзе");
            System.out.println("Новый студент успешно добавлен!\nКоличество студентов: " + studentsCount);
        } catch (DBException e) {
            e.printStackTrace();
        }

        System.out.println("---");

        System.out.println("Ищем последнего зачисленного студента...");
        Student student = null;
        try {
            student = dbService.getStudent(studentsCount);
        } catch (DBException e) {
            e.printStackTrace();
        }
        System.out.println("  (id = " + student.getId() + ") " + student.getLastName() + " " + student.getFirstName()
                + " " + student.getMiddleName());

        System.out.println("---");

        System.out.println("Отчисляем студента с id = 22 ...");
        try {
            studentsCount = dbService.deleteStudent(22);
            System.out.println("Студент отчислен!\nКоличество студентов: " + studentsCount);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
    
    private static void workWithTeachers() {
        System.out.println("Нанимаем нового преподавателя ...");
        int teacherCount = 0;
        try {
            teacherCount = dbService.addTeacher("Моше", "Евкакиевич", "Попхадзе");
            System.out.println("Новый преподаватель успешно добавлен!\nКоличество преподавателей: " + teacherCount);
        } catch (DBException e) {
            e.printStackTrace();
        }

        System.out.println("---");

        System.out.println("Ищем последнего нанятого преподавателя...");
        Teacher teacher = null;
        try {
            teacher = dbService.getTeacher(teacherCount);
        } catch (DBException e) {
            e.printStackTrace();
        }
        System.out.println("  (id = " + teacher.getId() + ") " + teacher.getLastName() + " " + teacher.getFirstName()
                + " " + teacher.getMiddleName());

        System.out.println("---");

        System.out.println("Увольняем последнего нанятого преподавателя...");
        try {
            teacherCount = dbService.deleteTeacher(teacherCount);
            System.out.println("Преподаватель уволен!\nКоличество преподавателей: " + teacherCount);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
    
    public static void schowUnivwrsityShedule() {
        System.out.println("Расписание университета ...");
        List<Schedule> schedule = null;
        
        try {
            schedule = dbService.getAllSchedule();
        } catch (DBException e) {
            e.printStackTrace();
        }
        for (Schedule row : schedule) {
            System.out.print(row.getDayOfWeek() + " " + row.getParity() + " " + row.getLesson() + ": \n");
            for(Lecture lecture : row.getLectures()) {
                System.out.println(lecture.getSubject().getName() + " / " + lecture.getTeacher().getLastName() + " / " + lecture.getGroup().getName() + " / " + lecture.getClassroom().getName());
            }
            System.out.println();
        }
    }
}
