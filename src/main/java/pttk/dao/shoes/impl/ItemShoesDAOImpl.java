package pttk.dao.shoes.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.shoes.ItemShoesDAO;
import pttk.dao.shoes.ShoesDAO;
import pttk.model.shoes.ItemShoes;
import pttk.util.impl.ItemShoesMapper;

import java.util.List;

public class ItemShoesDAOImpl extends BaseDAOImpl<ItemShoes> implements ItemShoesDAO {
    private final ShoesDAO shoesDAO = new ShoesDAOImpl();


    @Override
    public List<ItemShoes> findAll() {
        String sql = "SELECT * FROM ItemShoes";
        List<ItemShoes> listItemShoes =  query(sql, new ItemShoesMapper());
        listItemShoes.stream().forEach(itemShoes -> {
            itemShoes.setShoes(shoesDAO.getShoesByItemShoesId(itemShoes.getId()));
        });
        return listItemShoes;
    }

    @Override
    public List<ItemShoes> findAll(int limit, int offset) {
        String sql = "SELECT * FROM ItemShoes LIMIT ?, ?";
        List<ItemShoes> listItemShoes =  query(sql, new ItemShoesMapper(), offset, limit);
        listItemShoes.stream().forEach(itemShoes -> {
            itemShoes.setShoes(shoesDAO.getShoesByItemShoesId(itemShoes.getId()));
        });
        return listItemShoes;
    }

    @Override
    public List<ItemShoes> getAllShoesForMan() {
        String sql = "SELECT * FROM ItemShoes";
        List<ItemShoes> listItemShoes =  query(sql, new ItemShoesMapper());
        listItemShoes.stream().forEach(itemShoes -> {
            itemShoes.setShoes(shoesDAO.getShoesForManByItemShoesId(itemShoes.getId()));
        });
        return listItemShoes;
    }

    @Override
    public List<ItemShoes> getAllShoesForWomen() {
        String sql = "SELECT * FROM ItemShoes";
        List<ItemShoes> listItemShoes =  query(sql, new ItemShoesMapper());
        listItemShoes.stream().forEach(itemShoes -> {
            itemShoes.setShoes(shoesDAO.getShoesForWomenByItemShoesId(itemShoes.getId()));
        });
        return listItemShoes;
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM ItemShoes";
        return count(sql);
    }

    @Override
    public ItemShoes findById(int id) {
        String sql = "SELECT * FROM ItemShoes WHERE id = ?";
        List<ItemShoes> listItemShoes =  query(sql, new ItemShoesMapper(), id);
        listItemShoes.stream().forEach(itemShoes -> {
            itemShoes.setShoes(shoesDAO.getShoesByItemShoesId(itemShoes.getId()));
        });
        return listItemShoes.isEmpty() ? null : listItemShoes.get(0);
    }

    @Override
    public List<ItemShoes> findByName(String name) {
        name = "%" + name + "%";
        String sql = "SELECT * FROM ItemShoes, Shoes WHERE " +
                "Shoes.ItemShoesID = ItemShoes.ID " +
                "AND Shoes.Name like ?";
        List<ItemShoes> listItemShoes =  query(sql, new ItemShoesMapper(), name);
        listItemShoes.stream().forEach(itemShoes -> {
            itemShoes.setShoes(shoesDAO.getShoesByItemShoesId(itemShoes.getId()));
        });
        return listItemShoes;
    }
}
