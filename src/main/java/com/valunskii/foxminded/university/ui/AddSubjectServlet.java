package com.valunskii.foxminded.university.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.SubjectService;

@WebServlet("/addSubjectServlet")
public class AddSubjectServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(AddSubjectServlet.class);
    SubjectService service = new SubjectService();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        
        String responsePage = "getSubjectListServlet";
        
        try {
            service.addSubject(name);
        } catch (DAOException e) {
            log.error(e);
            responsePage = "daoerror.jsp";
        }
        response.sendRedirect(responsePage);
    }
}
