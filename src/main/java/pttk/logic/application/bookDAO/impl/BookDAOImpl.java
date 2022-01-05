package pttk.logic.application.bookDAO.impl;

import pttk.logic.application.BaseDAOImpl;
import pttk.logic.application.bookDAO.AuthorDAO;
import pttk.logic.application.bookDAO.BookDAO;
import pttk.logic.application.bookDAO.PublisherDAO;
import pttk.model.book.Author;
import pttk.model.book.Book;
import pttk.model.book.Publisher;
import pttk.util.impl.BookMapper;

import java.util.List;

public class BookDAOImpl extends BaseDAOImpl<Book> implements BookDAO {

    public PublisherDAO publisherDAO = new PublisherDAOImpl();
    private final AuthorDAO authorDAO = new AuthorDAOImpl();

    @Override
    public Book getBookByItemBookId(int itemBookID) {
        String sql = "SELECT * FROM Book WHERE ItemBookId = ?";
        List<Book> bookList = query(sql, new BookMapper(), itemBookID);
        Book book = bookList.isEmpty() ? null : bookList.get(0);
        if (book != null) {
            book.setAuthor(authorDAO.getAuthorById(book.getAuthor().getId()));
            book.setPublisher(publisherDAO.getPublisherById(book.getPublisher().getId()));
        }
        return book;
    }

    @Override
    public Book save(Book book) {
        Author author = authorDAO.save(book.getAuthor());
        Publisher publisher = publisherDAO.save(book.getPublisher());
        String sql = "INSERT INTO Book(AuthorID, PublisherID, Title, Type, Quantity, PageNumber, PublicationDate, Price, Language, Description) VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Long id = insert(sql, author.getId(), publisher.getId(), book.getTitle(), book.getType(), book.getQuantity(), book.getPageNumber(), book.getPublicationDate(), book.getPrice(), book.getLanguage(), book.getDescription());
        book.setId(Math.toIntExact(id));
        return book;
    }

    @Override
    public Book update(Book book) {
        String sql = "UPDATE Book SET Title = ?, Type = ?, Quantity = ?, Language = ?, PageNumber = ?, PublicationDate = ?, Price = ? , Description = ? WHERE ID = ?";
        update(sql, book.getTitle(), book.getType(), book.getQuantity(), book.getLanguage(), book.getPageNumber(), book.getPublicationDate(), book.getPrice(), book.getDescription());
        authorDAO.update(book.getAuthor());
        publisherDAO.update(book.getPublisher());
        return book;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Book WHERE id = ?";
        update(sql, id);
    }

}
