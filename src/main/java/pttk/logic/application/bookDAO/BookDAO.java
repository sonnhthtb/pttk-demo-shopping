package pttk.logic.application.bookDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.book.Book;

import java.util.List;

public interface BookDAO extends BaseDAO<Book> {
    Book getBookByItemBookId(int itemBookID);

    Book save(Book book);

    Book update(Book book);

    void delete(Integer id);

    int getCount();

    List<Book> findAll(int limit, int offset);

    Book findById(Integer id);

    List<Book> findAll();

}
