package service.implement;

import dao.StudentDao;
import dao.UniversityDao;
import model.Student;
import model.University;
import service.UniversityService;

import java.util.List;

public class UniversityServiceImpl implements UniversityService {
    private UniversityDao universityDao;

    public UniversityServiceImpl(UniversityDao universityDao) {
        this.universityDao = universityDao;
    }

    @Override
    public List<University> getUniversityList() throws Exception {
        return universityDao.getUniversityList();
    }
}
