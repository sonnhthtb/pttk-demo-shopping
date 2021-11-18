package pttk.service.impl;

import pttk.dao.shoes.ItemShoesDAO;
import pttk.dao.shoes.impl.ItemShoesDAOImpl;
import pttk.model.shoes.ItemShoes;
import pttk.service.ItemShoesService;
import pttk.util.RowMapper;

import java.util.List;

public class ItemShoesServiceImpl implements ItemShoesService {

    private final ItemShoesDAO itemShoesDAO = new ItemShoesDAOImpl();

    @Override
    public ItemShoes findShoesById(int itemShoesId) {
        return itemShoesDAO.findById(itemShoesId);
    }

    @Override
    public List<ItemShoes> findAllItemShoes() {
        return itemShoesDAO.findAll();
    }

    @Override
    public List<ItemShoes> findAll(int limit, int offset) {
        return itemShoesDAO.findAll(limit, offset);
    }

    @Override
    public List<ItemShoes> findByName(String name) {
        return itemShoesDAO.findByName(name);
    }

    @Override
    public int getTotalItem() {
        return itemShoesDAO.getTotalItem();
    }
}
