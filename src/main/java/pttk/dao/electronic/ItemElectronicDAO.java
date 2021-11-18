package pttk.dao.electronic;


import pttk.dao.BaseDAO;
import pttk.model.electronic.ItemElectronic;

import java.util.List;

public interface ItemElectronicDAO extends BaseDAO<ItemElectronic> {
    List<ItemElectronic> findAll();
    List<ItemElectronic> findAItemElectronics(int limit, int offset);
    ItemElectronic findItemElectronicById(int ItemElectronicId);
}
