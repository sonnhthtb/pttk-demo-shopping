package pttk.dao.book;

import pttk.dao.BaseDAO;
import pttk.entity.Book;
import pttk.entity.ItemBook;

import java.util.List;

public interface BookDAO extends BaseDAO<Book> {
    Book getBookByItemBookId(int itemBookID);
}
