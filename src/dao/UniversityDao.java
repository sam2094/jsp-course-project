package dao;

import model.University;

import java.util.List;

public interface UniversityDao {
    List<University> getUniversityList()  throws Exception;
}
