package vn.grooo.util.impl;

import vn.grooo.entity.ItemClothes;
import vn.grooo.entity.LineItemClothes;
import vn.grooo.entity.LineItemClothes;
import vn.grooo.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LineItemClothesMapper implements RowMapper<LineItemClothes> {
    @Override
    public LineItemClothes mapRow(ResultSet rs) {
        try{
            LineItemClothes lineItemClothes = new LineItemClothes();
            ItemClothes itemClothes = new ItemClothes();
            lineItemClothes.setQuantity(rs.getInt("Quantity"));
            itemClothes.setId(rs.getInt("ItemClothesID"));
            lineItemClothes.setItemClothes(itemClothes);
            return lineItemClothes;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
