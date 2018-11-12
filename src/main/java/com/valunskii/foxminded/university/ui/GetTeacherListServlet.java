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

@WebServlet("/getTeacherListServlet")
public class GetTeacherListServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(GetTeacherListServlet.class);
    TeacherService service = new TeacherService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Teacher> teachers = null;
        try {
            teachers = service.getAllTeachers();
        } catch (DAOException e) {
            log.error(e);
            e.printStackTrace();
        }

        request.setAttribute("teachers", teachers);
        request.setAttribute("true_page", this.getServletName());
        this.getServletContext().getRequestDispatcher("/teachers.jsp").forward(request, response);
    }
}
