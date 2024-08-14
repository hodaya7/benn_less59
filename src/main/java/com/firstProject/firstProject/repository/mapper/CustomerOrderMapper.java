package com.firstProject.firstProject.repository.mapper;

import com.firstProject.firstProject.model.CustomerOrder;
import com.firstProject.firstProject.model.CustomerOrderCurrency;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerOrderMapper implements RowMapper<CustomerOrder> {
    @Override
    public CustomerOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        //מה שחזר ממפה ללונג
        return new CustomerOrder(rs.getLong("id"),
                rs.getLong("customer_id"),
                rs.getString("item_name"),
                rs.getLong("price"),
                CustomerOrderCurrency.valueOf(rs.getString("currency")));//להפוך מסארינג לאינם
    }
}
