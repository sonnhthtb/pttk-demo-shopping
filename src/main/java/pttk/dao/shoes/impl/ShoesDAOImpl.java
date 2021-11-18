package pttk.dao.shoes.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.shoes.ShoesDAO;
import pttk.model.shoes.Shoes;
import pttk.model.shoes.ShoesForMan;
import pttk.model.shoes.ShoesForWomen;
import pttk.util.impl.ShoesMapper;

import java.util.List;

public class ShoesDAOImpl extends BaseDAOImpl<Shoes> implements ShoesDAO {

    private final ShoesForManImpl shoesForManImpl = new ShoesForManImpl();
    private final ShoesForWomenImpl shoesForWomenImpl = new ShoesForWomenImpl();

    @Override
    public Shoes getShoesByItemShoesId(int itemShoesId) {
        String sql = "SELECT * FROM Shoes WHERE Shoes.ItemShoesID = ?";
        List<Shoes> listShoes = query(sql, new ShoesMapper(), itemShoesId);
        Shoes shoes = listShoes.isEmpty() ? null : listShoes.get(0);
        if(shoes == null) return null;
        ShoesForMan shoesForMan = shoesForManImpl.getShoesForManByShoesID(shoes);
        ShoesForWomen shoesForWomen = shoesForWomenImpl.getShoesForWomenByShoesID(shoes);
        if (shoesForMan != null) return  shoesForMan;
        if (shoesForWomen != null) return shoesForWomen;
        return null;
    }

    @Override
    public Shoes getShoesForManByItemShoesId(int itemShoesId) {
        String sql = "SELECT * FROM Shoes WHERE Shoes.ItemShoesID = ?";
        List<Shoes> listShoes = query(sql, new ShoesMapper(), itemShoesId);
        Shoes shoes = listShoes.isEmpty() ? null : listShoes.get(0);
        if(shoes == null) return null;
        ShoesForMan shoesForMan = shoesForManImpl.getShoesForManByShoesID(shoes);
        return  shoesForMan;
    }

    @Override
    public Shoes getShoesForWomenByItemShoesId(int itemShoesId) {
        String sql = "SELECT * FROM Shoes WHERE Shoes.ItemShoesID = ?";
        List<Shoes> listShoes = query(sql, new ShoesMapper(), itemShoesId);
        Shoes shoes = listShoes.isEmpty() ? null : listShoes.get(0);
        if(shoes == null) return null;
        ShoesForWomen shoesForWomen = shoesForWomenImpl.getShoesForWomenByShoesID(shoes);
        return  shoesForWomen;
    }
}
