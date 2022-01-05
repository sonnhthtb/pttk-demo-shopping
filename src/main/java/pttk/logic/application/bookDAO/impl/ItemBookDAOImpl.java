package pttk.logic.application.bookDAO.impl;

import pttk.logic.application.BaseDAOImpl;
import pttk.logic.application.bookDAO.BookDAO;
import pttk.logic.application.bookDAO.ItemBookDAO;
import pttk.model.book.Book;
import pttk.model.book.ItemBook;
import pttk.util.impl.ItemBookMapper;

import java.util.List;

public class ItemBookDAOImpl extends BaseDAOImpl<ItemBook> implements ItemBookDAO {

    private final BookDAO bookDAO = new BookDAOImpl();

    @Override
    public List<ItemBook> findAll() {
        String sql = "SELECT * FROM ItemBook";
        List<ItemBook> itemBookList = query(sql, new ItemBookMapper());
        itemBookList.stream().forEach(itemBook -> {
            itemBook.setBook(bookDAO.getBookByItemBookId(itemBook.getId()));
        });
        return itemBookList;
    }

    @Override
    public List<ItemBook> findAll(int limit, int offset) {
        String sql = "SELECT * FROM ItemBook LIMIT ?, ?";
        List<ItemBook> itemBookList = query(sql, new ItemBookMapper(), offset, limit);
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
        List<ItemBook> itemBookList = query(sql, new ItemBookMapper(), id);
        itemBookList.stream().forEach(itemBook -> {
            itemBook.setBook(bookDAO.getBookByItemBookId(itemBook.getId()));
        });
        return itemBookList.isEmpty() ? null : itemBookList.get(0);
    }

    @Override
    public List<ItemBook> findByName(String name) {
        name = "%" + name + "%";
        String sql = "SELECT * FROM ItemBook, Book WHERE " +
                "ItemBook.BookID = Book.ID " +
                "AND Book.Title like ?";

        List<ItemBook> itemBookList = query(sql, new ItemBookMapper(), name);
        itemBookList.stream().forEach(itemBook -> {
            itemBook.setBook(bookDAO.getBookByItemBookId(itemBook.getId()));
        });
        return itemBookList;
    }

    @Override
    public ItemBook save(ItemBook itemBook) {
        String sql = "INSERT INTO Itembook(BookID, Price, ImageUrl, Barcode) VALUE( ?, ?, ?, ?)";
        Long id = insert(sql, itemBook.getBook().getId(), itemBook.getPrice(), itemBook.getImageUrl(), itemBook.getBarcode());
        return findById(Math.toIntExact(id));
    }

    @Override
    public ItemBook update(ItemBook itemBook) {
        String sql = "UPDATE ItemBook SET  Price = ?, ImageUrl = ?, Barcode = ? WHERE ID = ?";
        update(sql, itemBook.getPrice(), itemBook.getImageUrl(), itemBook.getBarcode(), itemBook.getId());
        return findById(itemBook.getId());
    }

    @Override
    public void delete(Integer id) {
        Book book = bookDAO.getBookByItemBookId(id);
        bookDAO.delete(book.getId());
        String sql = "DELETE FROM ItemBook WHERE id = ?";
        update(sql, id);
    }

    @Override
    public ItemBook findByBookId(Integer bookId) {
        String sql = "SELECT * FROM ItemBook WHERE BookID = ?";
        List<ItemBook> itemBookList = query(sql, new ItemBookMapper(), bookId);
        itemBookList.stream().forEach(itemBook -> {
            itemBook.setBook(bookDAO.getBookByItemBookId(itemBook.getId()));
        });
        return itemBookList.isEmpty() ? null : itemBookList.get(0);
    }

}
