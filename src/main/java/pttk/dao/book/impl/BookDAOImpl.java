package pttk.dao.book.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.book.AuthorDAO;
import pttk.dao.book.BookDAO;
import pttk.dao.book.PublisherDAO;
import pttk.model.book.Book;
import pttk.util.impl.BookMapper;

import java.util.List;

public class BookDAOImpl extends BaseDAOImpl<Book> implements BookDAO {

    private AuthorDAO authorDAO = new AuthorDAOImpl();
    public PublisherDAO publisherDAO = new PublisherDAOImpl();

    @Override
    public Book getBookByItemBookId(int itemBookID) {
        String sql = "SELECT * FROM Book WHERE ItemBookId = ?";
        List<Book> bookList = query(sql, new BookMapper(), itemBookID);
        Book book =  bookList.isEmpty() ? null : bookList.get(0);
        if (book != null) {
            book.setAuthor(authorDAO.getAuthorById(book.getAuthor().getId()));
            book.setPublisher(publisherDAO.getPublisherById(book.getPublisher().getId()));
        }
        return book;
    }

}
