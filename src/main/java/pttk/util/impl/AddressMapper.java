package pttk.util.impl;

import pttk.model.user.Address;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class AddressMapper implements RowMapper<Address> {

    @Override
    public Address mapRow(ResultSet rs) {
        try {
            Address address = new Address();
            address.setId(rs.getInt("ID"));
            address.setNumberHouse(rs.getString("Number"));
            address.setStreet(rs.getString("Street"));
            address.setDistrict(rs.getString("District"));
            address.setCity(rs.getString("City"));
            return address;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
