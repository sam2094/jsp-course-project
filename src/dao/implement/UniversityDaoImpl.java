package dao.implement;

import dao.DataManager;
import dao.UniversityDao;
import model.Student;
import model.University;
import util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UniversityDaoImpl implements UniversityDao {
    @Override
    public List<University> getUniversityList() throws Exception {
        List<University> universityList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from university";
        try {
            connection = DataManager.getConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    University university = new University();
                    university.setId(resultSet.getLong("id"));
                    university.setName(resultSet.getString("name"));
                    universityList.add(university);
                }
            } else {
                System.out.println("No connection");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                JdbcUtility.close(connection, preparedStatement, resultSet);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return universityList;
    }
}
