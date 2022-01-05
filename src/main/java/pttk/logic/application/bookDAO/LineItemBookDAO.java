package pttk.logic.application.bookDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.book.LineItemBook;

import java.util.List;

public interface LineItemBookDAO extends BaseDAO<LineItemBook> {
    Long create(int cardId, int itemBookId, int quantityB);

    List<LineItemBook> findByCartId(int cartId);

    void updateQuantity(int quantity, int id);

    void deleteLineItemBook(int id);

    LineItemBook findById(int id);

    LineItemBook findByCartIdAndItemBookId(int cartId, int itemBookId);
}
