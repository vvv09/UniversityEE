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
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Classroom> classrooms = null;
        try {
            classrooms = ClassroomService.getAllClassrooms();
        } catch (DAOException e) {
            log.error(e);
            e.printStackTrace();
        }
	    
	    request.setAttribute("classrooms", classrooms);
	    request.setAttribute("true_page", this.getServletName());
	    this.getServletContext().getRequestDispatcher("/classrooms.jsp").forward(request, response);
	}
}
