package vn.grooo.util.impl;

import vn.grooo.entity.ItemShoes;
import vn.grooo.entity.LineItemShoes;
import vn.grooo.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LineItemShoesMapper implements RowMapper<LineItemShoes> {

    @Override
    public LineItemShoes mapRow(ResultSet rs) {
        try{
            LineItemShoes lineItemShoes = new LineItemShoes();
            ItemShoes itemShoes = new ItemShoes();
            lineItemShoes.setQuantity(rs.getInt("Quantity"));
            itemShoes.setId(rs.getInt("ItemShoesID"));
            lineItemShoes.setItemShoes(itemShoes);
            return lineItemShoes;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
