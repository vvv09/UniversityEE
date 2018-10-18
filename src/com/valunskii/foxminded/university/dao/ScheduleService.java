package com.valunskii.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import com.valunskii.foxminded.university.domain.Schedule;

public class ScheduleService {
    public static List<Schedule> getAllSchedule() throws DBException{
        try {
            return (new ScheduleDao().get());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}
