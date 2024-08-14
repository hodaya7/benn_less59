package com.firstProject.firstProject.repository.mapper;

import com.firstProject.firstProject.model.Student;
import com.firstProject.firstProject.model.StudentPaymentMethod;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Student(rs.getLong("id"),
                           rs.getString("first_name"),
                           rs.getString("last_name"),
                           rs.getString("email"),
                           StudentPaymentMethod.valueOf(rs.getString("payment_method")));
    }
}
