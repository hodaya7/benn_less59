package com.firstProject.firstProject.service;

import com.firstProject.firstProject.model.Student;

import java.util.List;

public interface StudentService {
    void createStudent(Student student);
    void updateStudentById(Long studentId, Student student);
    void deleteStudent(Long id);

    Student getStudentById(Long id);

    List<Student> getStudensByFirstName(String firstName);
    List<Student> getAllStudents();
}
