package dao.implement;

import dao.DataManager;
import dao.ScheduleDao;
import model.Schedule;
import model.Student;
import model.University;
import util.JdbcUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDaoImpl implements ScheduleDao {
    @Override
    public List<Schedule> getScheduleList() throws Exception {
        List<Schedule> scheduleList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from schedule as sc left join student on sc.student_id = student.id left join university on sc.university_id = university.id";
        try {
            connection = DataManager.getConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Schedule schedule = new Schedule();
                    Student student = new Student();
                    University university = new University();
                    university.setId(resultSet.getLong("university.id"));
                    university.setName(resultSet.getString("university.name"));
                    student.setId(resultSet.getLong("student.id"));
                    student.setName(resultSet.getString("student.name"));
                    student.setSurname(resultSet.getString("student.surname"));
                    student.setEmail(resultSet.getString("student.email"));
                    student.setBirthdate(resultSet.getDate("student.birthdate"));
                    schedule.setId(resultSet.getLong("sc.id"));
                    schedule.setStudent(student);
                    schedule.setUniversity(university);
                    scheduleList.add(schedule);
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
        return scheduleList;
    }

    @Override
    public boolean addSchedule(Schedule schedule) throws Exception {
        boolean result = false;
        String query = "insert into schedule (student_id , university_id) values(?,?)";
        try (Connection connection = DataManager.getConnection(); PreparedStatement preparedStatement =
                connection.prepareStatement(query)) {
            if (connection != null) {
                preparedStatement.setLong(1, schedule.getStudent().getId());
                preparedStatement.setLong(2, schedule.getUniversity().getId());
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
