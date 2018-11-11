package com.valunskii.foxminded.university.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Classroom;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.ClassroomService;

@WebServlet("/getClassroomServlet")
public class GetClassroomServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(GetClassroomListServlet.class);
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Classroom classroom = null;
        try {
            classroom = ClassroomService.getClassroom(Integer.parseInt(request.getParameter("id")));
        } catch (DAOException e) {
            log.error(e);
            e.printStackTrace();
        }
        
        request.setAttribute("classroom", classroom);
        this.getServletContext().getRequestDispatcher("/editclassroomform.jsp").forward(request, response);
    }
}
