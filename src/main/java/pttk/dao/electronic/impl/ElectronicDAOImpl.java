package pttk.dao.electronic.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.electronic.ComputerDAO;
import pttk.dao.electronic.ElectronicDAO;
import pttk.dao.electronic.MobileDAO;
import pttk.model.electronic.Computer;
import pttk.model.electronic.Electronic;
import pttk.model.electronic.Mobile;
import pttk.util.impl.ElectronicMapper;

import java.util.List;

public class ElectronicDAOImpl extends BaseDAOImpl<Electronic> implements ElectronicDAO {
    final private ComputerDAOImpl computerDAOImpl = new ComputerDAOImpl();
    final private MobileDAOImpl mobileDAOImpl = new MobileDAOImpl();
    @Override
    public Electronic findElectronicByItemElectronicId(int electronicId) {
        String sql = "SELECT * FROM Electronic WHERE ItemShoesId = ?";
        List<Electronic> electronicList = query(sql, new ElectronicMapper(), electronicId);
        Electronic electronic =  electronicList.isEmpty() ? null : electronicList.get(0);
        if (electronic != null) {
            Computer computer = computerDAOImpl.findComputerByElectronicId(electronic);
            Mobile mobile = mobileDAOImpl.findMobileByElectronicId(electronic);
            if(computer!=null) return computer;
            if(mobile!=null) return mobile;
        }
        return null;

    }
}
