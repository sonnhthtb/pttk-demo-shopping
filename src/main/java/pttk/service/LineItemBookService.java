package pttk.service;

import pttk.model.book.ItemBook;
import pttk.model.book.LineItemBook;

import java.util.List;

public interface LineItemBookService {
    Long create(int cartId, int itemBookId, int quantityB);
    List<LineItemBook> findByCartId(int cartId);
}
