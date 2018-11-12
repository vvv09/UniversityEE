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

@WebServlet("/editSubjectServlet")
public class EditSubjectServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(EditSubjectServlet.class);
    SubjectService service = new SubjectService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        try {
            service.updateSubject(id, name);
        } catch (DAOException e) {
            log.error(e);
            e.printStackTrace();
        }
        response.sendRedirect("getSubjectListServlet");
    }
}
