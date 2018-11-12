package com.valunskii.foxminded.university.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Subject;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.SubjectService;

@WebServlet("/getSubjectListServlet")
public class GetSubjectListServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(GetSubjectListServlet.class);
    SubjectService service = new SubjectService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Subject> subjects = null;
        try {
            subjects = service.getAllSubjects();
        } catch (DAOException e) {
            log.error(e);
            e.printStackTrace();
        }

        request.setAttribute("subjects", subjects);
        request.setAttribute("true_page", this.getServletName());
        this.getServletContext().getRequestDispatcher("/subjects.jsp").forward(request, response);
    }
}
