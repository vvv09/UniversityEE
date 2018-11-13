package com.valunskii.foxminded.university.ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.SubjectService;
import com.valunskii.foxminded.university.service.TeacherService;

@WebServlet("/addTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(AddTeacherServlet.class);
    TeacherService service = new TeacherService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        
        try {
            service.addTeacher(firstName, middleName, lastName);
        } catch (DAOException e) {
            log.error(e);
            e.printStackTrace();
        }
        response.sendRedirect("getTeacherListServlet");
    }
}
