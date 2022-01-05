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

    private final AuthorDAO authorDAO = new AuthorDAOImpl();
    public PublisherDAO publisherDAO = new PublisherDAOImpl();

    @Override
    public Book getBookByItemBookId(int itemBookID) {
        String sql = "SELECT Book.* FROM ItemBook,Book WHERE ItemBook.BookId = Book.ID AND ItemBook.ID = ?";
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
        String sql = "INSERT INTO Book(AuthorID, PublisherID, Title, Type, Quantity, PageNumber, Price, Language, Description) VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Long id = insert(sql, author.getId(), publisher.getId(), book.getTitle(), book.getType(), book.getQuantity(), book.getPageNumber(), book.getPrice(), book.getLanguage(), book.getDescription());
        book.setId(Math.toIntExact(id));
        return book;
    }

    @Override
    public Book update(Book book) {
        String sql = "UPDATE Book SET Title = ?, Type = ?, Quantity = ?, Language = ?, PageNumber = ?, Price = ? , Description = ? WHERE ID = ?";
        update(sql, book.getTitle(), book.getType(), book.getQuantity(), book.getLanguage(), book.getPageNumber(), book.getPrice(), book.getDescription(), book.getId());
        authorDAO.update(book.getAuthor());
        publisherDAO.update(book.getPublisher());
        return book;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Book WHERE id = ?";
        update(sql, id);
    }

    @Override
    public int getCount() {
        String sql = "select count(*) from book";
        return count(sql);
    }

    @Override
    public List<Book> findAll(int limit, int offset) {
        String sql = "SELECT * FROM Book LIMIT ?, ?";
        return query(sql, new BookMapper(), offset, limit);
    }

    @Override
    public Book findById(Integer id) {
        String sql = "SELECT * FROM Book where id = ?";
        List<Book> bookList = query(sql, new BookMapper(), id);
        Book book = bookList.isEmpty() ? null : bookList.get(0);
        if (book != null) {
            book.setAuthor(authorDAO.getAuthorById(book.getAuthor().getId()));
            book.setPublisher(publisherDAO.getPublisherById(book.getPublisher().getId()));
        }
        return book;
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM Book";
        return query(sql, new BookMapper());
    }

}
