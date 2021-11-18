package pttk.dao.book.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.book.BookDAO;
import pttk.dao.book.ItemBookDAO;
import pttk.model.book.ItemBook;
import pttk.util.impl.ItemBookMapper;

import java.util.List;

public class ItemBookDAOImpl extends BaseDAOImpl<ItemBook> implements ItemBookDAO {

    private final BookDAO bookDAO = new BookDAOImpl();

    @Override
    public List<ItemBook> findAll() {
        String sql = "SELECT * FROM ItemBook";
        List<ItemBook> itemBookList =  query(sql, new ItemBookMapper());
        itemBookList.stream().forEach(itemBook -> {
            itemBook.setBook(bookDAO.getBookByItemBookId(itemBook.getId()));
        });
        return itemBookList;
    }

    @Override
    public List<ItemBook> findAll(int limit, int offset) {
        String sql = "SELECT * FROM ItemBook LIMIT ?, ?";
        List<ItemBook> itemBookList =  query(sql, new ItemBookMapper(), offset, limit);
        itemBookList.stream().forEach(itemBook -> {
            itemBook.setBook(bookDAO.getBookByItemBookId(itemBook.getId()));
        });
        return itemBookList;
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM ItemBook";
        return count(sql);
    }

    @Override
    public ItemBook findById(int id) {
        String sql = "SELECT * FROM ItemBook WHERE id = ?";
        List<ItemBook> itemBookList =  query(sql, new ItemBookMapper(), id);
        itemBookList.stream().forEach(itemBook -> {
            itemBook.setBook(bookDAO.getBookByItemBookId(itemBook.getId()));
        });
        return itemBookList.isEmpty() ? null : itemBookList.get(0);
    }

    @Override
    public List<ItemBook> findByName(String name) {
        name += '%';
        String sql = "SELECT * FROM ItemBook, Book WHERE " +
                "Book.ItemBookID = ItemBookID " +
                "AND Book.Title like ?";

        List<ItemBook> itemBookList = query(sql, new ItemBookMapper(), name);
        itemBookList.stream().forEach(itemBook -> {
            itemBook.setBook(bookDAO.getBookByItemBookId(itemBook.getId()));
        });
        return itemBookList;
    }

}
