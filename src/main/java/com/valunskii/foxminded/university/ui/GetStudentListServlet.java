package com.valunskii.foxminded.university.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Student;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.StudentService;

@WebServlet("/getStudentListServlet")
public class GetStudentListServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(GetStudentListServlet.class);
    StudentService service = new StudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> students = null;
        String responsePage = "/students.jsp";
        
        try {
            students = service.getAllStudents();
        } catch (DAOException e) {
            log.error(e);
            responsePage = "/daoerror.jsp";
        }

        request.setAttribute("students", students);
        request.setAttribute("true_page", this.getServletName());
        this.getServletContext().getRequestDispatcher(responsePage).forward(request, response);
    }
}
