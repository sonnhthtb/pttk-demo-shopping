package pttk.dao.electronic;

import pttk.dao.BaseDAO;
import pttk.model.electronic.Electronic;

public interface ElectronicDAO extends BaseDAO<Electronic> {
    Electronic findElectronicByItemElectronicId(int ItemElectronicId);
}
