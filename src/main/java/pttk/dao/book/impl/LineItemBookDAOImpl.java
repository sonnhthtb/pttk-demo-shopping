package pttk.dao.book.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.book.LineItemBookDAO;
import pttk.model.book.LineItemBook;
import pttk.util.impl.LineItemBookMapper;

import java.util.List;

public class LineItemBookDAOImpl extends BaseDAOImpl<LineItemBook> implements LineItemBookDAO {

    @Override
    public Long create(int cardId, int itemBookId, int quantity) {
        String sql = "INSERT INTO LineItemBook (cartID, itemBookId, quantityB) VALUES (?, ?, ?)";
        Long ans = insert(sql, cardId, itemBookId, quantity);
        return ans;
    }

    @Override
    public List<LineItemBook> findByCartId(int cartId) {
        String sql = "select * from LineItemBook where cartId = ?";
        List<LineItemBook> list = query(sql, new LineItemBookMapper(), cartId);

        return list;
    }

    @Override
    public void updateQuantity(int quantity, int id) {
        String sql = "update LineItemBook set quantityB = ? where id = ?";
        update(sql,quantity, id);
    }

    @Override
    public void deleteLineItemBook(int id) {
        String sql = "delete from lineItemBook where id = ?";
        update(sql,id);
    }

}
