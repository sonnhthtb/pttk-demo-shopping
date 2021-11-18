package pttk.dao.clothes.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.clothes.ItemClothesDAO;
import pttk.model.clothes.Clothes;
import pttk.model.clothes.ItemClothes;
import pttk.model.clothes.Origin;
import pttk.model.clothes.Trademark;
import pttk.util.impl.*;

import java.util.List;

public class ItemClothesDAOImpl extends BaseDAOImpl<ItemClothes> implements ItemClothesDAO {
    @Override
    public List<ItemClothes> findAll() {
        String sql = "SELECT * FROM ItemClothes";
        List<ItemClothes> listItemClothes =  query(sql, new ItemClothesMapper());
        listItemClothes.stream().forEach(itemClothes -> {
            itemClothes.setClothes(getClothesByItemClothesId(itemClothes.getId()));
        });
        return listItemClothes;
    }

    @Override
    public List<ItemClothes> findAll(int limit, int offset) {
        String sql = "SELECT * FROM ItemClothes LIMIT ?, ?";
        List<ItemClothes> listItemClothes =  query(sql, new ItemClothesMapper(), offset, limit);
        listItemClothes.stream().forEach(itemClothes -> {
            itemClothes.setClothes(getClothesByItemClothesId(itemClothes.getId()));
        });
        return listItemClothes;
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM ItemClothes";
        return count(sql);
    }

    @Override
    public ItemClothes findById(int id) {
        String sql = "SELECT * FROM ItemClothes WHERE id = ?";
        List<ItemClothes> listItemClothes =  query(sql, new ItemClothesMapper(), id);
        listItemClothes.stream().forEach(itemClothes -> {
            itemClothes.setClothes(getClothesByItemClothesId(itemClothes.getId()));
        });
        return listItemClothes.isEmpty() ? null : listItemClothes.get(0);
    }

    @Override
    public List<ItemClothes> findByName(String name) {
        name += '%';
        String sql = "SELECT * FROM ItemClothes, Clothes WHERE " +
                "Clothes.ItemClothesID = ItemClothesID " +
                "AND Clothes.Title like ?";
        List<ItemClothes> listItemClothes =  query(sql, new ItemClothesMapper(), name);
        listItemClothes.stream().forEach(itemClothes -> {
            itemClothes.setClothes(getClothesByItemClothesId(itemClothes.getId()));
        });
        return listItemClothes;
    }

    private Clothes getClothesByItemClothesId(int itemClothesID) {
        String sql = "SELECT * FROM Clothes WHERE ItemClothesId = ?";
        List<Clothes> listClothes = query(sql, new ClothesMapper(), itemClothesID);
        Clothes clothes =  listClothes.isEmpty() ? null : listClothes.get(0);
        if (clothes != null) {
            clothes.setTrademark(getTrademarkById(clothes.getTrademark().getId()));
            clothes.setOrigin(getOriginById(clothes.getOrigin().getId()));
        }
        return clothes;
    }

    private Trademark getTrademarkById(int trademarkId) {
        String sql = "SELECT * FROM Trademark WHERE ID = ?";
        List<Trademark> trademarksList =  query(sql, new TrademarkMapper(), trademarkId);
        return trademarksList.isEmpty() ? null : trademarksList.get(0);
    }

    private Origin getOriginById(int originId) {
        String sql = "SELECT * FROM Origin WHERE ID = ?";
        List<Origin> originList =  query(sql, new OriginMapper(), originId);
        return originList.isEmpty() ? null : originList.get(0);
    }

}
