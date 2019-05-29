package dao.implement;

import dao.DataManager;
import dao.StudentDao;
import model.Student;
import util.JdbcUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> getStudentList() throws Exception {
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from student where status = 1";
        try {
            connection = DataManager.getConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getLong("id"));
                    student.setName(resultSet.getString("name"));
                    student.setSurname(resultSet.getString("surname"));
                    student.setEmail(resultSet.getString("email"));
                    student.setBirthdate(resultSet.getDate("birthdate"));
                    studentList.add(student);
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
        return studentList;
    }

    @Override
    public long addStudent(Student student) throws Exception {
        long prevId = 0;
        String query = "insert into student (name,surname,email,birthdate) " +
                "values (?,?,?,?)";
        try (Connection connection = DataManager.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) { // try with resources (send important object for connect for automaticaly close and intitialize)
            if (connection != null) {
                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getSurname());
                preparedStatement.setString(3, student.getEmail());
                preparedStatement.setDate(4, new java.sql.Date(student.getBirthdate().getTime()));
                preparedStatement.execute();
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        prevId = generatedKeys.getLong(1);
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return prevId;
    }

}
