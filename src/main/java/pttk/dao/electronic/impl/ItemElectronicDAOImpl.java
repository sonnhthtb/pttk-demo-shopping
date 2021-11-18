package pttk.dao.electronic.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.electronic.ElectronicDAO;
import pttk.dao.electronic.ItemElectronicDAO;
import pttk.model.electronic.ItemElectronic;
import pttk.util.impl.ItemElectronicMapper;

import java.util.List;

public class ItemElectronicDAOImpl extends BaseDAOImpl<ItemElectronic> implements ItemElectronicDAO {

    private final ElectronicDAO electronicDAO = new ElectronicDAOImpl();

    @Override
    public void update(String sql, Object... parameters) {

    }

    @Override
    public Long insert(String sql, Object... parameters) {
        return null;
    }

    @Override
    public int count(String sql, Object... parameters) {
        return 0;
    }

    @Override
    public List<ItemElectronic> findAll() {
        String sql = "SELECT * FROM ItemElectronic";
        List<ItemElectronic> itemElectronicList =  query(sql, new ItemElectronicMapper());
        itemElectronicList.stream().forEach(itemElectronic -> {
            itemElectronic.setElectronic(electronicDAO.findElectronicByItemElectronicId(itemElectronic.getId()));
        });
        return itemElectronicList;
    }

    @Override
    public List<ItemElectronic> findAItemElectronics(int limit, int offset) {
        return null;
    }

    @Override
    public ItemElectronic findItemElectronicById(int ItemElectronicId) {
        String sql = "SELECT * FROM ItemElectronic WHERE id = ?";
        List<ItemElectronic> itemElectronicList =  query(sql, new ItemElectronicMapper(), ItemElectronicId);
        itemElectronicList.stream().forEach(itemElectronic -> {
            itemElectronic.setElectronic(electronicDAO.findElectronicByItemElectronicId(itemElectronic.getId()));
        });
        return itemElectronicList.isEmpty() ? null : itemElectronicList.get(0);
    }
}
