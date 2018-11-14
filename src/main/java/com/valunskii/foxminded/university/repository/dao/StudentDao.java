package com.valunskii.foxminded.university.repository.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Group;
import com.valunskii.foxminded.university.repository.entity.Student;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.repository.executor.Executor;

public class StudentDao {
    private static Logger log = Logger.getLogger(StudentDao.class);
    private Executor executor = new Executor();

    public List<Student> getAll() throws DAOException {
        log.info("Looking for student list");
        return executor.execQuery(result -> {
            List<Student> list = new ArrayList<>();
            while (result.next()) {
                list.add(new Student(result.getInt("student_id"), result.getString("first_name"),
                        result.getString("middle_name"), result.getString("last_name"),
                        new Group(result.getInt("group_id"), result.getString("name"))));
            }
            log.info("Return student list");
            return list;
        }, "SELECT students.student_id, students.first_name, students.middle_name, students.last_name, groups.group_id, groups.name "
                + "FROM students JOIN groups ON groups.group_id = students.group_id ORDER BY student_id");
    }

    public Student get(int id) throws DAOException {
        log.info("Looking for student with id = " + id);
        return executor.execQuery(result -> {
            result.next();
            log.info("Return student");
            return new Student(result.getInt("student_id"), result.getString("first_name"),
                    result.getString("middle_name"), result.getString("last_name"),
                    new Group(result.getInt("group_id"), result.getString("name")));
        }, "SELECT students.student_id, students.first_name, students.middle_name, students.last_name, groups.group_id, groups.name "
                + "FROM public.students JOIN public.groups ON groups.group_id = students.group_id WHERE student_id = ?",
                id);
    }

    public void add(String firstName, String middleName, String lastName, int groupId) throws DAOException {
        log.info("Add new student");
        executor.execUpdate("INSERT INTO students(first_name, middle_name, last_name, group_id) VALUES (?, ?, ?, ?);",
                firstName, middleName, lastName, groupId);
        log.info("Student added");
    }

    public void delete(int id) throws DAOException {
        log.info("Delete student");
        executor.execUpdate("DELETE FROM students WHERE student_id = ?", id);
        log.info("Student deleted");
    }

    public void update(int id, String firstName, String middleName, String lastName, int groupId) throws DAOException {
        log.info("Update student with id = " + id);
        executor.execUpdate("UPDATE students SET first_name = ?, middle_name = ?, last_name = ?, group_id = ? WHERE student_id = ?",
                firstName, middleName, lastName, groupId, id);
        log.info("Student updated");
    }
}
