package dao;

import model.Student;

import java.util.List;

public interface StudentDao  {
    List<Student> getStudentList() throws  Exception;
    long addStudent(Student student) throws  Exception;
}
