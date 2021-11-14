package vn.grooo.util.impl;

import vn.grooo.entity.Address;
import vn.grooo.entity.Customer;
import vn.grooo.util.RowMapper;

import java.sql.ResultSet;

public class AddressMapper implements RowMapper<Address> {

    @Override
    public Address mapRow(ResultSet rs) {
        try {
            Address address = new Address();
            address.setId(rs.getInt("ID"));
            address.setNumberHouse(rs.getString("NumberHouse"));
            address.setStreet(rs.getString("Street"));
            address.setDistrict(rs.getString("District"));
            address.setCity(rs.getString("City"));
            address.setNation(rs.getString("Nation"));
            return address;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
