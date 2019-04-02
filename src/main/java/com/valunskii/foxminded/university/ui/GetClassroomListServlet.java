package com.valunskii.foxminded.university.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Classroom;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.ClassroomService;

@WebServlet("/getClassroomListServlet")
public class GetClassroomListServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(GetClassroomListServlet.class);
    ClassroomService service = new ClassroomService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Classroom> classrooms = null;
		String responsePage = "/classrooms.jsp";
		
        try {
            classrooms = service.getAllClassrooms();
        } catch (DAOException e) {
            log.error(e);
            responsePage = "/daoerror.jsp";
        }
	    
	    request.setAttribute("classrooms", classrooms);
	    request.setAttribute("true_page", this.getServletName());
	    this.getServletContext().getRequestDispatcher(responsePage).forward(request, response);
	}
}
