package com.valunskii.foxminded.university.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Student;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.StudentService;

@WebServlet("/getStudentServlet")
public class GetStudentServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(GetStudentServlet.class);
    StudentService service = new StudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Student student = null;
	String responsePage = "/editstudentform.jsp";
	
	try {
        student = service.getStudent(Integer.parseInt(request.getParameter("id")));
    } catch (DAOException e) {
        log.error(e);
        responsePage = "/daoerror.jsp";
    }
	request.setAttribute("student", student);
    this.getServletContext().getRequestDispatcher(responsePage).forward(request, response);
	}
}
