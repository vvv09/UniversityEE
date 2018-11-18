package com.valunskii.foxminded.university.ui;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.valunskii.foxminded.university.repository.entity.Parity;
import com.valunskii.foxminded.university.repository.entity.Schedule;
import com.valunskii.foxminded.university.repository.entity.Teacher;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.ScheduleService;
import com.valunskii.foxminded.university.service.TeacherService;

@WebServlet("/getTeacherScheduleServlet")
public class GetTeacherScheduleServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(GetTeacherScheduleServlet.class);
    ScheduleService scheduleService = new ScheduleService();
    TeacherService teacherService = new TeacherService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String parity = request.getParameter("parity");
        String dayOfWeek = request.getParameter("dayOfWeek");
        int teacherId = Integer.parseInt(request.getParameter("id"));

        Teacher teacher = null;
        List<Schedule> schedule = null;
        String responsePage = "/teacherschedule.jsp";
        
        try {
            teacher = teacherService.getTeacher(teacherId);
        } catch (DAOException e) {
            log.error(e);
            responsePage = "/daoerror.jsp";
        }
        
        try {
            if ((parity == null && dayOfWeek == null) || (parity.equals("ЛЮБАЯ") && dayOfWeek.equals("ЛЮБОЙ"))) {
                schedule = scheduleService.getTeacherSchedule(teacherId);
            } else {
                if (parity.equals("ЛЮБАЯ")) {
                    schedule = scheduleService.getTeacherDayScheduleExceptParity(teacherId,
                            DayOfWeek.valueOf(dayOfWeek));
                } else if (dayOfWeek.equals("ЛЮБОЙ")) {
                    schedule = scheduleService.getTeacherDayScheduleExceptDay(teacherId, Parity.valueOf(parity));
                } else {
                    schedule = scheduleService.getTeacherDaySchedule(teacherId, DayOfWeek.valueOf(dayOfWeek),
                            Parity.valueOf(parity));
                }
            }
        } catch (DAOException e) {
            log.error(e);
            responsePage = "/daoerror.jsp";
        }

        request.setAttribute("teacher", teacher);
        request.setAttribute("schedule", schedule);
        request.setAttribute("true_page", this.getServletName());
        this.getServletContext().getRequestDispatcher(responsePage).forward(request, response);
    }
}
