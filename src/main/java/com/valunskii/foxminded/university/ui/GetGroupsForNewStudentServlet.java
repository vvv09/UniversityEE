package com.valunskii.foxminded.university.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Group;
import com.valunskii.foxminded.university.repository.entity.Student;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.GroupService;

@WebServlet("/getGroupsForNewStudentServlet")
public class GetGroupsForNewStudentServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(GetGroupsForNewStudentServlet.class);
    GroupService service = new GroupService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Group> groups = null;
        String responsePage = "/addstudentform.jsp";
        
        try {
            groups = service.getAllGroups();
        } catch (DAOException e) {
            log.error(e);
            responsePage = "/daoerror.jsp";
        }

        request.setAttribute("groups", groups);
        request.setAttribute("true_page", this.getServletName());

        this.getServletContext().getRequestDispatcher(responsePage).forward(request, response);
    }

}
