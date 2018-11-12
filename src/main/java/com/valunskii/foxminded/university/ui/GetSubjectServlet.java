package com.valunskii.foxminded.university.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Subject;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.SubjectService;

@WebServlet("/getSubjectServlet")
public class GetSubjectServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(GetSubjectServlet.class);
    SubjectService service = new SubjectService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Subject subject = null;
        try {
            subject = service.getSubject(Integer.parseInt(request.getParameter("id")));
        } catch (DAOException e) {
            log.error(e);
            e.printStackTrace();
        }

        request.setAttribute("subject", subject);
        this.getServletContext().getRequestDispatcher("/editsubjectform.jsp").forward(request, response);
    }
}
