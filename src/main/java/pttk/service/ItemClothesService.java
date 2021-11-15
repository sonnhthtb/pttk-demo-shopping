package pttk.service;

import pttk.entity.ItemBook;
import pttk.entity.ItemClothes;

import java.util.List;

public interface ItemClothesService {
    ItemClothes findClothesById(int itemClothesId);
    List<ItemClothes> findAllItemClothes();
    List<ItemClothes> findAll(int limit, int offset);
    int getTotalItem();
}
