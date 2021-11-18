package pttk.util.impl;

import pttk.model.book.ItemBook;
import pttk.model.electronic.Computer;
import pttk.model.electronic.Electronic;
import pttk.model.electronic.Mobile;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class ElectronicMapper implements RowMapper<Electronic> {
    @Override
    public Electronic mapRow(ResultSet rs) {
        try {
            Electronic electronic = new Electronic();
            electronic.setId(rs.getInt("ID"));
            electronic.setBrand(rs.getString("Brand"));
            electronic.setDiscount(rs.getFloat("Discount"));
            electronic.setOrigin(rs.getString("Origin"));
            electronic.setPrice(rs.getFloat("Price"));
            electronic.setDescription(rs.getString("Description"));
            Computer computer = new Computer();
            computer.setId(rs.getInt("Id"));
            Mobile mobile = new Mobile();
            mobile.setId(rs.getInt("Id"));
            electronic.setComputer(computer);
            electronic.setMobile(mobile);
            return electronic;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
