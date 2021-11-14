package vn.grooo.util.impl;

import vn.grooo.entity.Customer;
import vn.grooo.entity.FullName;
import vn.grooo.util.RowMapper;

import java.sql.ResultSet;

public class FullNameMapper implements RowMapper<FullName> {
    @Override
    public FullName mapRow(ResultSet rs) {
        try {
            FullName fullName = new FullName();
            fullName.setId(rs.getInt("ID"));
            fullName.setFirstName(rs.getString("FirstName"));
            fullName.setMiddleName(rs.getString("MiddleName"));
            fullName.setLastName(rs.getString("LastName"));
            return fullName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
