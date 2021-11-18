package pttk.dao.electronic.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.electronic.MobileDAO;
import pttk.model.electronic.Mobile;
import pttk.util.impl.MobileMapper;

import java.util.List;

public class MobileDAOImpl extends BaseDAOImpl<Mobile> implements MobileDAO {
    @Override
    public Mobile findMobileByElectronicId(int ElectronicId) {
        String sql = "SELECT * FROM Mobile";
        List<Mobile> mobileList =  query(sql, new MobileMapper());
        return mobileList.isEmpty() ? null : mobileList.get(0);
    }
}
