package com.firstProject.firstProject.repository;

import com.firstProject.firstProject.model.Student;

import java.util.List;

public interface StudentRepositoryLess62Ex {
    void createStudent(Student student);
    void updateStudentById(Long studentId, Student student);
    void deleteStudent(Long id);

    Student getStudentById(Long id);

    List<Student> getStudensByFirstName(String firatName);
    List<Student> getAllStudents();
}
