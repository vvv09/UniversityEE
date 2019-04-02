package com.valunskii.foxminded.university.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Group;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.GroupService;

@WebServlet("/getGroupServlet")
public class GetGroupServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(GetGroupServlet.class);
    GroupService service = new GroupService();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Group group = null;
        String responsePage = "/editgroupform.jsp";
        
        try {
            group = service.getGroup(Integer.parseInt(request.getParameter("id")));
        } catch (DAOException e) {
            log.error(e);
            responsePage = "/daoerror.jsp";
        }
        
        request.setAttribute("group", group);
        this.getServletContext().getRequestDispatcher(responsePage).forward(request, response);
    }
}
