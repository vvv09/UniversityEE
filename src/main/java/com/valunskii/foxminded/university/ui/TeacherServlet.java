package com.valunskii.foxminded.university.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Teacher;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.TeacherService;


@WebServlet("/teacherServlet")
public class TeacherServlet extends HttpServlet {
final static Logger log = Logger.getLogger(ClassroomServlet.class);
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> teachers = null;
        try {
            teachers = TeacherService.getAllTeachers();
        } catch (DAOException e) {
            log.error(e);
            e.printStackTrace();
        }
        
        request.setAttribute("teachers", teachers);
        this.getServletContext().getRequestDispatcher("/teachers.jsp").forward(request, response);
    }
}
