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
    ClassroomService service = new ClassroomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Classroom classroom = null;
        String responsePage = "/editclassroomform.jsp";
        try {
            classroom = service.getClassroom(Integer.parseInt(request.getParameter("id")));
        } catch (DAOException e) {
            log.error(e);
            responsePage = "/daoerror.jsp";
        }
        
        request.setAttribute("classroom", classroom);
        this.getServletContext().getRequestDispatcher(responsePage).forward(request, response);
    }
}
