package pttk.dao.book.impl;

import pttk.entity.Author;
import pttk.entity.Book;
import pttk.entity.ItemBook;
import pttk.util.impl.AuthorMapper;
import pttk.util.impl.BookMapper;
import pttk.util.impl.ItemBookMapper;
import pttk.dao.BaseDAOImpl;
import pttk.dao.book.ItemBookDAO;
import pttk.entity.Publisher;
import pttk.util.impl.PublisherMapper;

import java.util.List;

public class ItemBookDAOImpl extends BaseDAOImpl<ItemBook> implements ItemBookDAO {
    @Override
    public List<ItemBook> findAll() {
        String sql = "SELECT * FROM ItemBook";
        List<ItemBook> itemBookList =  query(sql, new ItemBookMapper());
        itemBookList.stream().forEach(itemBook -> {
            itemBook.setBook(getBookByItemBookId(itemBook.getId()));
        });
        return itemBookList;
    }

    @Override
    public List<ItemBook> findAll(int limit, int offset) {
        String sql = "SELECT * FROM ItemBook LIMIT ?, ?";
        List<ItemBook> itemBookList =  query(sql, new ItemBookMapper(), offset, limit);
        itemBookList.stream().forEach(itemBook -> {
            itemBook.setBook(getBookByItemBookId(itemBook.getId()));
        });
        return itemBookList;
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM ItemBook";
        return count(sql);
    }

    private Book getBookByItemBookId(int itemBookID) {
        String sql = "SELECT * FROM Book WHERE ItemBookId = ?";
        List<Book> bookList = query(sql, new BookMapper(), itemBookID);
        Book book =  bookList.isEmpty() ? null : bookList.get(0);
        if (book != null) {
            book.setAuthor(getAuthorById(book.getAuthor().getId()));
            book.setPublisher(getPublisherById(book.getPublisher().getId()));
        }
        return book;
    }

    private Author getAuthorById(int authorId) {
        String sql = "SELECT * FROM Author WHERE ID = ?";
        List<Author> authorList =  query(sql, new AuthorMapper(), authorId);
        return authorList.isEmpty() ? null : authorList.get(0);
    }

    private Publisher getPublisherById(int publisherId) {
        String sql = "SELECT * FROM Publisher WHERE ID = ?";
        List<Publisher> publisherList =  query(sql, new PublisherMapper(), publisherId);
        return publisherList.isEmpty() ? null : publisherList.get(0);
    }

}
