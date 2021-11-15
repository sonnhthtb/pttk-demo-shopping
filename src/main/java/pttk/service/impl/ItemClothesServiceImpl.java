package pttk.service.impl;

import pttk.dao.book.ItemBookDAO;
import pttk.dao.book.impl.ItemBookDAOImpl;
import pttk.dao.clothes.ItemClothesDAO;
import pttk.dao.clothes.impl.ItemClothesDAOImpl;
import pttk.entity.ItemBook;
import pttk.entity.ItemClothes;
import pttk.service.ItemBookService;
import pttk.service.ItemClothesService;

import java.util.List;

public class ItemClothesServiceImpl implements ItemClothesService {

    private final ItemClothesDAO itemClothesDAO = new ItemClothesDAOImpl();

    @Override
    public ItemClothes findClothesById(int itemClothesId) {
        return itemClothesDAO.findById(itemClothesId);
    }

    @Override
    public List<ItemClothes> findAllItemClothes() {
        return itemClothesDAO.findAll();
    }

    @Override
    public List<ItemClothes> findAll(int limit, int offset) {
        return itemClothesDAO.findAll(limit, offset);
    }

    @Override
    public int getTotalItem() {
        return itemClothesDAO.getTotalItem();
    }
}
