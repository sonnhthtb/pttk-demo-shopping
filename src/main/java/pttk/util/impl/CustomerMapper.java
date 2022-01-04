package pttk.util.impl;

import pttk.model.user.User;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class CustomerMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs) {
        try {
            User customer = new User();
            customer.setId(rs.getInt("ID"));
            customer.setRole(rs.getString("Role"));
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
