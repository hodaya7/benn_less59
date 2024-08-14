package com.firstProject.firstProject.controller;

import com.firstProject.firstProject.model.Student;
import com.firstProject.firstProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentControllerLess62Ex {
    @Autowired
    StudentService studentService;

    @PostMapping("/student/create")
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @PostMapping("/student/update/{studenrId}")
    public void updateStudentById(@PathVariable Long studentId, @RequestBody Student student){
        studentService.updateStudentById(studentId, student);
    }

    @DeleteMapping("/student/delete/{studentId}")
    public void deleteStudentById(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/student/all/{firstName}")
    public List<Student> getStudentsByFirstName(@PathVariable String firstName){
        return studentService.getStudensByFirstName(firstName);
    }

    @GetMapping("/student/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    //עם המיילים לא עשינו בשיעור
}
