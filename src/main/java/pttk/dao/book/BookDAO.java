package pttk.dao.book;

import pttk.dao.BaseDAO;
import pttk.model.book.Book;

public interface BookDAO extends BaseDAO<Book> {
    Book getBookByItemBookId(int itemBookID);
}
