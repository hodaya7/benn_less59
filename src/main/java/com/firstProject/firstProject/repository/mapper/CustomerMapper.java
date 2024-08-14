package com.firstProject.firstProject.repository.mapper;

import com.firstProject.firstProject.model.Customer;
import com.firstProject.firstProject.model.CustomerStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//less62
public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                                  //מה שחזר ממפה ללונג
        return new Customer(rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                CustomerStatus.valueOf(rs.getString("status")));//להפוך מסארינג לאינם
    }
}
