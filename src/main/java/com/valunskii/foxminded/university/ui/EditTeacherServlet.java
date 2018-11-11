package com.valunskii.foxminded.university.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.TeacherService;

@WebServlet("/editTeacherServlet")
public class EditTeacherServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(EditTeacherServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("id"));
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		
		try {
            TeacherService.updateTeacher(id, firstName, middleName, lastName);
        } catch (DAOException e) {
            log.error(e);
            e.printStackTrace();
        }
		response.sendRedirect("getTeacherListServlet");
	}
}