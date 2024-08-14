package com.firstProject.firstProject.repository;

import com.firstProject.firstProject.model.Customer;
import com.firstProject.firstProject.model.CustomerStatus;
import com.firstProject.firstProject.repository.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryLess61 {
    private static final String CUSTOMER_TABLE_NAME = "customer";
    @Autowired
    private JdbcTemplate jdbcTemplate;//הקלאיינט h2 הגיע מהגראדל ששמנו

//    @Override
//    public Long createCustomer(Customer customer) {
//        String sql = "INSERT INTO " + CUSTOMER_TABLE_NAME + " (first_name, last_name, email, status) VALUES (?, ?, ?, ?);"+
//                "SELECT_LAST_INSERT_ID();";

//
//       return jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getStatus().name());//להפוך מאינם לסטרינג
//
//    }
public Long createCustomer(Customer customer) {
    String insertSql = "INSERT INTO " + CUSTOMER_TABLE_NAME + " (first_name, last_name, email, status) VALUES (?, ?, ?, ?)";

    // הוספת רשומה
    jdbcTemplate.update(insertSql, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getStatus().name());

    // SQL לשליפת המזהה האחרון שנוצר
    String selectLastIdSql = "SELECT ID FROM " + CUSTOMER_TABLE_NAME + " ORDER BY ID DESC LIMIT 1";

    // שליפת המזהה האחרון שנוצר
    return jdbcTemplate.queryForObject(selectLastIdSql, Long.class);
}

    @Override
    public void updateCustomerById(Long customerId, Customer customer) {
        String sql = "UPDATE " + CUSTOMER_TABLE_NAME + " SET first_name=?, last_name=?, email=?, status=? WHERE id=?";
        jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getStatus().name(), customerId);
    }

    @Override
    public void deleteCustomer(Long id) {
        String sql = "DELETE FROM " + CUSTOMER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    //less62
    @Override
    public Customer getCustomerById(Long id) {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME + " WHERE id=?";
        try {
            //מה יכנס בסימן שאלה:
            return jdbcTemplate.queryForObject(sql, new CustomerMapper(), id);//כשיש תשובה עם אובייקט אחד
        } catch (EmptyResultDataAccessException error) {//אם אין תשובה כזו
            return null;
        }
    }

    @Override
    public List<Customer> getCustomersByFirstName(String firstName) {//כמה תשובות
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME + " WHERE first_name=?";
        try {
            return jdbcTemplate.query(sql, new CustomerMapper(), firstName);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME;
        try {
            return jdbcTemplate.query(sql, new CustomerMapper());
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }
//רשימה של לונגים ולא אובייקטים שצריך מאפר שלנו
    @Override
    public List<Long> getCustomersIdsByFirstName(String firstName) {
        String sql = "SELECT id FROM " + CUSTOMER_TABLE_NAME + " WHERE first_name=?";
        try {//יקבל גם את המחלקה שאליה רוצה למפות-לונג
            return jdbcTemplate.queryForList(sql, Long.class, firstName);//הקלאס שאליו ממפים
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomersByStatus(CustomerStatus status) {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME + " WHERE status=?";
        try {
            return jdbcTemplate.query(sql, new CustomerMapper(), status.name());
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }


}
