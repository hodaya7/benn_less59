package com.firstProject.firstProject.repository;

import com.firstProject.firstProject.model.CustomerOrder;
import com.firstProject.firstProject.repository.mapper.CustomerOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerOrderRepositoryImpl implements CustomerOrderRepositoryLess64{
    private static final String CUSTOMER_ORDER_TABLE_NAME = "customer_order";
    @Autowired
    private JdbcTemplate jdbcTemplate;//הקלאיינט h2 הגיע מהגראדל ששמנו

    @Override
    public void createCustomerOrder(CustomerOrder customerOrder) throws Exception {
        String sql = "INSERT INTO " + CUSTOMER_ORDER_TABLE_NAME + " (customer_id, item_name, price, currency) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, customerOrder.getCustomerId(), customerOrder.getItemName(), customerOrder.getPrice(), customerOrder.getCurrency().name());//להפוך מאינם לסטרינג
    }

    @Override
    public void updateCustomerOrderById(Long customerOrderId, CustomerOrder customerOrder) throws Exception {
        String sql = "UPDATE " + CUSTOMER_ORDER_TABLE_NAME + " SET customer_id=?, item_name=?, price=?, currency=? WHERE id=?";
        jdbcTemplate.update(sql, customerOrder.getCustomerId(), customerOrder.getItemName(), customerOrder.getPrice(), customerOrder.getCurrency().name(), customerOrderId);
    }

    @Override
    public void deleteCustomerOrder(Long id) throws Exception {
        String sql = "DELETE FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        String sql = "SELECT * FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE id=?";
        try {
            //מה יכנס בסימן שאלה:
            return jdbcTemplate.queryForObject(sql, new CustomerOrderMapper(), id);//כשחוזר אובייקט אחד
        } catch (EmptyResultDataAccessException error) {//אם אין תשובה כזו
            return null;
        }
    }

    @Override
    public List<CustomerOrder> getAllCustomerOrdersByCustomerId(long customerId) {
        String sql = "SELECT * FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE customer_id=?";
        try {
            //מה יכנס בסימן שאלה:
            return jdbcTemplate.query(sql, new CustomerOrderMapper(), customerId);//ליסט של אובייקטים
        } catch (EmptyResultDataAccessException error) {//אם אין תשובה כזו
            return null;
        }
    }
}
