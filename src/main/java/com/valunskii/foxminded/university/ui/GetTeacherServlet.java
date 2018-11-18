package com.valunskii.foxminded.university.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Teacher;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.TeacherService;

@WebServlet("/getTeacherServlet")
public class GetTeacherServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(GetTeacherServlet.class);
    TeacherService service = new TeacherService();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Teacher teacher = null;
	    String responsePage = "/editteacherform.jsp";
        try {
            teacher = service.getTeacher(Integer.parseInt(request.getParameter("id")));
        } catch (DAOException e) {
            log.error(e);
            responsePage = "/daoerror.jsp";
        }
        
        request.setAttribute("teacher", teacher);
        this.getServletContext().getRequestDispatcher(responsePage).forward(request, response);
	}
}
