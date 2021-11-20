package pttk.service.impl;

import pttk.dao.lineItemClothes.LineItemClothesDAO;
import pttk.dao.lineItemClothes.impl.LineItemClothesDAOImpl;
import pttk.model.book.LineItemBook;
import pttk.model.clothes.LineItemClothes;
import pttk.service.LineItemBookService;
import pttk.service.LineItemClothesService;

import java.util.List;

public class LineItemClothesServiceImpl implements LineItemClothesService {

    private final LineItemClothesDAO lineItemClothesDAO = new LineItemClothesDAOImpl();

    @Override
    public Long create(int cartId, int itemClothesId, int quantity) {
        return lineItemClothesDAO.create(cartId, itemClothesId, quantity);
    }

    @Override
    public List<LineItemClothes> findByCartId(int cartId) {
        return lineItemClothesDAO.findByCartId(cartId);
    }

    @Override
    public void updateQuantity(int quantity, int id) {
        lineItemClothesDAO.updateQuantity(quantity,id);
    }
}
