package com.valunskii.foxminded.university.service;

import java.time.DayOfWeek;
import java.util.List;

import com.valunskii.foxminded.university.repository.dao.ScheduleDao;
import com.valunskii.foxminded.university.repository.entity.Parity;
import com.valunskii.foxminded.university.repository.entity.Schedule;
import com.valunskii.foxminded.university.repository.exception.DAOException;

public class ScheduleService {
    private static ScheduleDao dao = new ScheduleDao();

    public List<Schedule> getAllSchedule() throws DAOException {
            return dao.get();
    }

    public List<Schedule> getGroupSchedule(int groupId) throws DAOException {
            return dao.getGroupSchedule(groupId);
    }

    public List<Schedule> getGroupDaySchedule(int groupId, DayOfWeek day, Parity parity)
            throws DAOException {
            return dao.getGroupDaySchedule(groupId, day, parity);
    }
    
    public List<Schedule> getGroupDayScheduleExceptParity(int groupId, DayOfWeek day)
            throws DAOException {
            return dao.getGroupDayScheduleExceptParty(groupId, day);
    }
    
    public List<Schedule> getGroupDayScheduleExceptDay(int groupId, Parity parity)
            throws DAOException {
            return dao.getGroupDayScheduleExceptDay(groupId, parity);
    }

    public List<Schedule> getTeacherSchedule(int teacherId) throws DAOException {
            return dao.getTeacherSchedule(teacherId);
    }

    public List<Schedule> getTeacherDaySchedule(int teacherId, DayOfWeek day, Parity parity)
            throws DAOException {
            return dao.getTeacherDaySchedule(teacherId, day, parity);
    }
    
    public List<Schedule> getTeacherDayScheduleExceptParity(int teacherId, DayOfWeek day)
            throws DAOException {
            return dao.getTeacherDayScheduleExceptParity(teacherId, day);
    }
    
    public List<Schedule> getTeacherDayScheduleExceptDay(int teacherId, Parity parity)
            throws DAOException {
            return dao.getTeacherDayScheduleExceptDay(teacherId, parity);
    }
}
