package pttk.dao.book;

import pttk.dao.BaseDAO;
import pttk.entity.book.Book;

public interface BookDAO extends BaseDAO<Book> {
    Book getBookByItemBookId(int itemBookID);
}
