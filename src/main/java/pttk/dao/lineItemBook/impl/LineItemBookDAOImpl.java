package pttk.dao.lineItemBook.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.lineItemBook.LineItemBookDAO;
import pttk.model.book.ItemBook;
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

}
