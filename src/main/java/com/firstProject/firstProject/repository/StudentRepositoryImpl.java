package com.firstProject.firstProject.repository;

import com.firstProject.firstProject.model.Student;
import com.firstProject.firstProject.repository.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepositoryLess62Ex{
    private static final String STUDENT_TABLE_NAME = "student";
    @Autowired
    private JdbcTemplate jdbcTemplate;//הקלאיינט הגיע מהגראדל ששמנו


    @Override
    public void createStudent(Student student) {
        String sql = "INSERT INTO " + STUDENT_TABLE_NAME + " (first_name, last_name, email, payment_method) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getFirstName(), student.getLastName(), student.getEmail(), student.getPaymentMethod().name());
    }

    @Override
    public void updateStudentById(Long studentId, Student student) {
        String sql = "UPDATE " + STUDENT_TABLE_NAME + " SET first_name=?, last_name=?, email=? WHERE id=?";
        jdbcTemplate.update(sql, student.getFirstName(), student.getLastName(), student.getEmail(), studentId);
    }

    @Override
    public void deleteStudent(Long id) {
        String sql = "DELETE FROM " + STUDENT_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Student getStudentById(Long id) {
        String sql = "SELECT * FROM " + STUDENT_TABLE_NAME + " WHERE id=?";
        try {
            //מה יכנס בסימן שאלה:
            return jdbcTemplate.queryForObject(sql, new StudentMapper(), id);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public List<Student> getStudensByFirstName(String firstName) {
        String sql = "SELECT * FROM " + STUDENT_TABLE_NAME + " WHERE first_name=?";
        try {
            return jdbcTemplate.query(sql, new StudentMapper(), firstName);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM " + STUDENT_TABLE_NAME;
        try {
            return jdbcTemplate.query(sql, new StudentMapper());
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

}
