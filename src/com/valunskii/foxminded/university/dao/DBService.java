package com.valunskii.foxminded.university.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.valunskii.foxminded.university.domain.Classroom;
import com.valunskii.foxminded.university.domain.Group;
import com.valunskii.foxminded.university.domain.Student;
import com.valunskii.foxminded.university.domain.Subject;
import com.valunskii.foxminded.university.domain.Teacher;

public class DBService {
    private final Connection connection;

    public DBService() {
        this.connection = getPostgresqlConnection();
    }

    public List<Group> getAllGroups() throws DBException {
        try {
            return (new GroupsDao(connection).getAll());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public List<Classroom> getAllClassrooms() throws DBException {
        try {
            return (new ClassroomDao(connection).getAll());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public List<Subject> getAllSubjects() throws DBException {
        try {
            return (new SubjectDao(connection).getAll());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
    
    public List<Teacher> getAllTeachers() throws DBException{
        try {
            return (new TeacherDao(connection).getAll());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
    
    public List<Student> getAllStudents() throws DBException{
        try {
            return (new StudentDao(connection).getAll());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
    
    public void addStudent(int id, String firstName, String middleName, String lastName) throws DBException {
        try {
            connection.setAutoCommit(false);
            StudentDao dao = new StudentDao(connection);
            dao.add(id, firstName, middleName, lastName);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {                
            }
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            } 
        }
    }
    
    public Student getStudent(int id) throws DBException {
        try {
            return (new StudentDao(connection).get(id));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
    
    public void deleteStudent(int id) throws DBException {
        try{
            StudentDao dao = new StudentDao(connection);
            dao.delete(id);
        } catch (SQLException e) {
            throw new DBException(e);
        }
        
    }

    public void printConnectInfo() {
        try {
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + connection.getMetaData().getDriverName());
            System.out.println("Autocommit: " + connection.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getPostgresqlConnection() {

        final String JDBC_DRIVER = "org.postgresql.Driver";
        final String DB_NAME = "jdbc:postgresql://localhost:5432/foxuniversity";
        final String USER = "postgres";
        final String PASS = "1568996";

        try {
            DriverManager.registerDriver((Driver) Class.forName(JDBC_DRIVER).newInstance());
            System.out.println("URL: " + DB_NAME + "\n");
            Connection connection = DriverManager.getConnection(DB_NAME, USER, PASS);
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
