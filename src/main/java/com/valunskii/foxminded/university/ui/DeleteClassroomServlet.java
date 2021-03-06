package com.valunskii.foxminded.university.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.ClassroomService;

@WebServlet("/deleteClassroomServlet")
public class DeleteClassroomServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(DeleteClassroomServlet.class);
    ClassroomService service = new ClassroomService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        String responsePage = "getClassroomListServlet";

        try {
            service.deleteClassroom(id);
        } catch (DAOException e) {
            log.error(e);
            responsePage = "daoerror.jsp";
        }
        response.sendRedirect(responsePage);
    }
}
