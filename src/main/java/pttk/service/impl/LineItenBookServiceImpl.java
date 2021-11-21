package pttk.service.impl;

import pttk.dao.lineItemBook.LineItemBookDAO;
import pttk.dao.lineItemBook.impl.LineItemBookDAOImpl;
import pttk.model.book.ItemBook;
import pttk.model.book.LineItemBook;
import pttk.service.LineItemBookService;

import java.util.List;

public class LineItenBookServiceImpl implements LineItemBookService {
    private final LineItemBookDAO lineItemBookDAO = new LineItemBookDAOImpl();

    @Override
    public Long create(int cartId, int itemBookId, int quantityB) {
        return lineItemBookDAO.create(cartId,itemBookId,quantityB);
    }

    @Override
    public List<LineItemBook> findByCartId(int cartId) {
        return lineItemBookDAO.findByCartId(cartId);
    }

    @Override
    public void updateQuantity(int quantity, int id) {
        lineItemBookDAO.updateQuantity(quantity, id);
    }

    @Override
    public void deleteLineItemBook(int id) {
        lineItemBookDAO.deleteLineItemBook(id);
    }

}
