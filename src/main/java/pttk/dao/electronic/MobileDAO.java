package pttk.dao.electronic;

import pttk.dao.BaseDAO;
import pttk.model.electronic.Mobile;

public interface MobileDAO extends BaseDAO<Mobile> {
    Mobile findMobileByElectronicId(int ElectronicId);
}
