package vn.grooo.util.impl;

import vn.grooo.entity.ItemBook;
import vn.grooo.entity.LineItemBook;
import vn.grooo.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LineItemBookMapper implements RowMapper<LineItemBook> {

    @Override
    public LineItemBook mapRow(ResultSet rs) {
        try{
            LineItemBook lineItemBook = new LineItemBook();
            ItemBook itemBook = new ItemBook();
            lineItemBook.setQuantity(rs.getInt("Quantity"));
            itemBook.setId(rs.getInt("ItemBookID"));
            lineItemBook.setItemBook(itemBook);
            return lineItemBook;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
