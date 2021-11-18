package pttk.dao.electronic;

import pttk.dao.BaseDAO;
import pttk.model.electronic.Electronic;

public interface ElectronicDAO extends BaseDAO<Electronic> {
    Electronic findElectronicById(int ElectronicId);
}
