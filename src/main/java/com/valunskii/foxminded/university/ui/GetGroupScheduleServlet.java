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

import com.valunskii.foxminded.university.repository.entity.Group;
import com.valunskii.foxminded.university.repository.entity.Parity;
import com.valunskii.foxminded.university.repository.entity.Schedule;
import com.valunskii.foxminded.university.repository.exception.DAOException;
import com.valunskii.foxminded.university.service.GroupService;
import com.valunskii.foxminded.university.service.ScheduleService;


@WebServlet("/getGroupScheduleServlet")
public class GetGroupScheduleServlet extends HttpServlet {
    final static Logger log = Logger.getLogger(GetGroupScheduleServlet.class);
    ScheduleService scheduleService = new ScheduleService();
    GroupService groupService = new GroupService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String parity = request.getParameter("parity");
        String dayOfWeek = request.getParameter("dayOfWeek");
        int groupId = Integer.parseInt(request.getParameter("id"));

        Group group = null;
        try {
            group = groupService.getGroup(groupId);
        } catch (DAOException e) {
            log.error(e);
        }
        List<Schedule> schedule = null;
        try {
            if ((parity == null && dayOfWeek == null) || (parity.equals("ЛЮБАЯ") && dayOfWeek.equals("ЛЮБОЙ"))) {
                schedule = scheduleService.getGroupSchedule(groupId);
            } else {
                if (parity.equals("ЛЮБАЯ")) {
                    schedule = scheduleService.getGroupDayScheduleExceptParity(groupId,
                            DayOfWeek.valueOf(dayOfWeek));
                } else if (dayOfWeek.equals("ЛЮБОЙ")) {
                    schedule = scheduleService.getGroupDayScheduleExceptDay(groupId, Parity.valueOf(parity));
                } else {
                    schedule = scheduleService.getGroupDaySchedule(groupId, DayOfWeek.valueOf(dayOfWeek),
                            Parity.valueOf(parity));
                }
            }
        } catch (DAOException e) {
            log.error(e);
        }

        request.setAttribute("group", group);
        request.setAttribute("schedule", schedule);
        request.setAttribute("true_page", this.getServletName());
        this.getServletContext().getRequestDispatcher("/groupschedule.jsp").forward(request, response);
    }
}
