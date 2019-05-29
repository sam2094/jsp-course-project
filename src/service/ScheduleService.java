package service;

import model.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getScheduleList() throws Exception;
    boolean addSchedule(Schedule schedule) throws Exception;
}
