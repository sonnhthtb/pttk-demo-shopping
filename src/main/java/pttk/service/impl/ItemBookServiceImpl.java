package pttk.service.impl;

import pttk.entity.ItemBook;
import pttk.dao.book.ItemBookDAO;
import pttk.dao.book.impl.ItemBookDAOImpl;
import pttk.service.ItemBookService;

import java.util.List;

public class ItemBookServiceImpl implements ItemBookService {

    private final ItemBookDAO itemBookDAO = new ItemBookDAOImpl();

    @Override
    public ItemBook findById(int itemBookId) {
        return itemBookDAO.findById(itemBookId);
    }

    @Override
    public List<ItemBook> findAll() {
        return itemBookDAO.findAll();
    }

    @Override
    public List<ItemBook> findAll(int limit, int offset) {
        return itemBookDAO.findAll(limit, offset);
    }

    @Override
    public int getTotalItem() {
        return itemBookDAO.getTotalItem();
    }
}
