package pttk.dao.electronic;

import pttk.dao.BaseDAO;
import pttk.model.electronic.Computer;

public interface ComputerDAO extends BaseDAO<Computer> {
    Computer findComputerByElectronicId (int ElectronicId);
}
