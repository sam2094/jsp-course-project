package dao;

import model.Schedule;

import java.util.List;

public interface ScheduleDao {
    List<Schedule> getScheduleList() throws Exception;
    boolean addSchedule(Schedule schedule) throws Exception;

}
