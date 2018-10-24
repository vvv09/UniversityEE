package com.valunskii.foxminded.university.service;

import java.time.DayOfWeek;
import java.util.List;

import com.valunskii.foxminded.university.repository.dao.ScheduleDao;
import com.valunskii.foxminded.university.repository.entity.Parity;
import com.valunskii.foxminded.university.repository.entity.Schedule;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class ScheduleService {
    private static ScheduleDao dao = new ScheduleDao();

    public static List<Schedule> getAllSchedule() throws DAOException {
            return (dao.get());
    }

    public static List<Schedule> getGroupSchedule(String groupName) throws DAOException {
            return (dao.getGroupSchedule(groupName));
    }

    public static List<Schedule> getGroupDaySchedule(String groupName, DayOfWeek day, Parity parity)
            throws DAOException {
            return (dao.getGroupDaySchedule(groupName, day, parity));
    }

    public static List<Schedule> getTacherSchedule(int teacherId) throws DAOException {
            return (dao.getTeacherSchedule(teacherId));
    }

    public static List<Schedule> getTeacherDaySchedule(int teacherId, DayOfWeek day, Parity parity)
            throws DAOException {
            return (dao.getTeacherDaySchedule(teacherId, day, parity));
    }
}
