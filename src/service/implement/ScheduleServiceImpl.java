package service.implement;

import dao.ScheduleDao;
import model.Schedule;
import service.ScheduleService;

import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {
    private ScheduleDao scheduleDao;

    public ScheduleServiceImpl(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    @Override
    public List<Schedule> getScheduleList() throws Exception {
        return scheduleDao.getScheduleList();
    }

    @Override
    public boolean addSchedule(Schedule schedule) throws Exception {
        return scheduleDao.addSchedule(schedule);
    }
}
