package com.valunskii.foxminded.university.service;

import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.List;

import com.valunskii.foxminded.university.repository.dao.ScheduleDao;
import com.valunskii.foxminded.university.repository.entity.Parity;
import com.valunskii.foxminded.university.repository.entity.Schedule;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class ScheduleService {
    public static List<Schedule> getAllSchedule() throws DAOException {
        try {
            return (new ScheduleDao().get());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Schedule> getGroupSchedule(String groupName) throws DAOException {
        try {
            return (new ScheduleDao().getGroupSchedule(groupName));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Schedule> getGroupDaySchedule(String groupName, DayOfWeek day, Parity parity)
            throws DAOException {
        try {
            return (new ScheduleDao().getGroupDaySchedule(groupName, day, parity));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public static List<Schedule> getTacherSchedule(int teacherId) throws DAOException {
        try {
            return (new ScheduleDao().getTeacherSchedule(teacherId));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Schedule> getTeacherDaySchedule(int teacherId, DayOfWeek day, Parity parity)
            throws DAOException {
        try {
            return (new ScheduleDao().getTeacherDaySchedule(teacherId, day, parity));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
