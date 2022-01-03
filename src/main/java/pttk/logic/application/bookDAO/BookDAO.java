package pttk.logic.application.bookDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.book.Book;

public interface BookDAO extends BaseDAO<Book> {
    Book getBookByItemBookId(int itemBookID);

    Book save(Book book, Integer itemBookId);

    Book update(Book book);

    void delete(Integer id);
}
