package dao.implement;

import dao.DataManager;
import model.Test;

import java.sql.*;

public class TestDaoImplement{
    public boolean addTest(Test test) throws Exception {
        boolean result = false;
        String query = "insert into test (name,image) values (?,?)";
        try (Connection connection = DataManager.getConnection(); PreparedStatement preparedStatement =
                connection.prepareStatement(query)) {
            if (connection != null) {
                preparedStatement.setString(1,test.getName());
                preparedStatement.setString(2,test.getImage());
                preparedStatement.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }
}
