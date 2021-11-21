package pttk.service.impl;

import pttk.dao.lineItemShoes.LineItemShoesDAO;
import pttk.dao.lineItemShoes.impl.LineItemShoesDAOImpl;
import pttk.service.LineItemShoesService;

public class LineItemShoesServiceImpl implements LineItemShoesService {

    private final LineItemShoesDAO lineItemShoesDAO = new LineItemShoesDAOImpl();

    @Override
    public Long create(int cartId, int itemShoesId, int quantity) {
        return lineItemShoesDAO.create(cartId, itemShoesId, quantity);
    }
}
