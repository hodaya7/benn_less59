package com.firstProject.firstProject.service;

import com.firstProject.firstProject.model.Student;
import com.firstProject.firstProject.repository.StudentRepositoryLess62Ex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepositoryLess62Ex studentRepository;
    @Override
    public void createStudent(Student student) {
         studentRepository.createStudent(student);
    }

    @Override
    public void updateStudentById(Long studentId, Student student) {
        studentRepository.updateStudentById(studentId, student);
    }

    @Override
    public void deleteStudent(Long id) {
      studentRepository.deleteStudent(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public List<Student> getStudensByFirstName(String firstName) {
        return studentRepository.getStudensByFirstName(firstName);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}
