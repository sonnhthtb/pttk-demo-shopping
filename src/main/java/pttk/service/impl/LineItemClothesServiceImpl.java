package pttk.service.impl;

import pttk.dao.lineItemClothes.LineItemClothesDAO;
import pttk.dao.lineItemClothes.impl.LineItemClothesDAOImpl;
import pttk.service.LineItemBookService;
import pttk.service.LineItemClothesService;

public class LineItemClothesServiceImpl implements LineItemClothesService {

    private final LineItemClothesDAO lineItemClothesDAO = new LineItemClothesDAOImpl();

    @Override
    public Long create(int cartId, int itemClothesId, int quantity) {
        return lineItemClothesDAO.create(cartId, itemClothesId, quantity);
    }
}
