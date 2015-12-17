package org.nac.sms.dao;

import java.util.List;

import org.nac.sms.model.Student;

public interface StudentDao {

    boolean insertStudent(Student student);
    List<Student> getAllStudents();
    boolean updateStudent(Student studentToBeUpdated);
    void deleteStudent(int studentID);
    Student getStudent(int studentID);
}
