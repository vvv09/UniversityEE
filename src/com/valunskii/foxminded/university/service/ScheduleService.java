package com.valunskii.foxminded.university.service;

import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.List;

import com.valunskii.foxminded.university.repository.dao.ScheduleDao;
import com.valunskii.foxminded.university.repository.entity.Parity;
import com.valunskii.foxminded.university.repository.entity.Schedule;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class ScheduleService {
    private static ScheduleDao dao = new ScheduleDao();

    public static List<Schedule> getAllSchedule() throws DAOException {
        try {
            return (dao.get());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Schedule> getGroupSchedule(String groupName) throws DAOException {
        try {
            return (dao.getGroupSchedule(groupName));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Schedule> getGroupDaySchedule(String groupName, DayOfWeek day, Parity parity)
            throws DAOException {
        try {
            return (dao.getGroupDaySchedule(groupName, day, parity));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Schedule> getTacherSchedule(int teacherId) throws DAOException {
        try {
            return (dao.getTeacherSchedule(teacherId));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Schedule> getTeacherDaySchedule(int teacherId, DayOfWeek day, Parity parity)
            throws DAOException {
        try {
            return (dao.getTeacherDaySchedule(teacherId, day, parity));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
