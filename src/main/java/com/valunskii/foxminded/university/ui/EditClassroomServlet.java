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

@WebServlet("/editClassroomServlet")
public class EditClassroomServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(EditClassroomServlet.class);
    ClassroomService service = new ClassroomService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        
        String responsePage = "getClassroomListServlet";

        try {
            service.updateClassroom(id, name);
        } catch (DAOException e) {
            log.error(e);
            responsePage = "daoerror.jsp";
        }
        response.sendRedirect("getClassroomListServlet");
    }
}
