package service;

import model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentList() throws  Exception;

    long  addStudent(Student student) throws  Exception;
}
