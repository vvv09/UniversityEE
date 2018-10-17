package com.valunskii.foxminded.university.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.valunskii.foxminded.university.domain.Classroom;
import com.valunskii.foxminded.university.domain.Group;
import com.valunskii.foxminded.university.domain.Lecture;
import com.valunskii.foxminded.university.domain.Lesson;
import com.valunskii.foxminded.university.domain.Parity;
import com.valunskii.foxminded.university.domain.Schedule;
import com.valunskii.foxminded.university.domain.Student;
import com.valunskii.foxminded.university.domain.Subject;
import com.valunskii.foxminded.university.domain.Teacher;

public class DBService {
//    private final Connection connection;

//    public DBService() {
//        this.connection = getPostgresqlConnection();
//    }

    public List<Group> getAllGroups() throws DBException {
        try {
            return (new GroupsDao().getAll());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public List<Classroom> getAllClassrooms() throws DBException {
        try {
            return (new ClassroomDao().getAll());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public List<Subject> getAllSubjects() throws DBException {
        try {
            return (new SubjectDao().getAll());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public List<Teacher> getAllTeachers() throws DBException {
        try {
            return (new TeacherDao().getAll());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public int addTeacher(String firstName, String middleName, String lastName) throws DBException {
        try {
            TeacherDao dao = new TeacherDao();
            List<Teacher> list = dao.getAll();
            dao.add(list.size() + 1, firstName, middleName, lastName);
            return dao.getAll().size();
        } catch (SQLException e) {
            throw new DBException(e);
        } 
    }

    public Teacher getTeacher(int id) throws DBException {
        try {
            return (new TeacherDao().get(id));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public int deleteTeacher(int id) throws DBException {
        try {
            TeacherDao dao = new TeacherDao();
            dao.delete(id);
            return dao.getAll().size();
        } catch (SQLException e) {
            throw new DBException(e);
        }

    }

    public List<Student> getAllStudents() throws DBException {
        try {
            return (new StudentDao().getAll());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public int addStudent(String firstName, String middleName, String lastName) throws DBException {
        try {
            StudentDao dao = new StudentDao();
            List<Student> list = dao.getAll();
            dao.add(list.size() + 1, firstName, middleName, lastName);
            return dao.getAll().size();
        } catch (SQLException e) {
            throw new DBException(e);
        } 
    }

    public Student getStudent(int id) throws DBException {
        try {
            return (new StudentDao().get(id));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public int deleteStudent(int id) throws DBException {
        try {
            StudentDao dao = new StudentDao();
            dao.delete(id);
            return dao.getAll().size();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public List<Schedule> getAllSchedule() throws DBException{
        try {
            return (new ScheduleDao().get());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

//    public void printConnectInfo() {
//        try {
//            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
//            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
//            System.out.println("Driver: " + connection.getMetaData().getDriverName());
//            System.out.println("Autocommit: " + connection.getAutoCommit());
//            System.out.println("______________\n");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


}
