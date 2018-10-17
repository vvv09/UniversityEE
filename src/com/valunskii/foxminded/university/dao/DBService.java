package com.valunskii.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import com.valunskii.foxminded.university.domain.Classroom;
import com.valunskii.foxminded.university.domain.Group;

import com.valunskii.foxminded.university.domain.Schedule;
import com.valunskii.foxminded.university.domain.Student;
import com.valunskii.foxminded.university.domain.Subject;
import com.valunskii.foxminded.university.domain.Teacher;

public class DBService {

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
}
