package pttk.service.impl;

import pttk.dao.electronic.ItemElectronicDAO;
import pttk.dao.electronic.impl.ItemElectronicDAOImpl;
import pttk.model.electronic.Computer;
import pttk.model.electronic.ItemElectronic;
import pttk.model.electronic.Mobile;
import pttk.service.ItemElectronicService;

import java.util.List;

public class ItemElectronicServiceImpl implements ItemElectronicService {
    ItemElectronicDAO itemElectronicDAO = new ItemElectronicDAOImpl();
    @Override
    public ItemElectronic findElectronicById(int itemElectronicId) {
        return itemElectronicDAO.findItemElectronicById(itemElectronicId);
    }

    @Override
    public List<ItemElectronic> findAll() {
        return itemElectronicDAO.findAll();
    }

    @Override
    public List<ItemElectronic> findAllItemElectronic(int limit, int offset) {
        return itemElectronicDAO.findAllItemElectronics(limit, offset);
    }


    @Override
    public List<ItemElectronic> findAllComputer() {
        return itemElectronicDAO.findAllComputer();
    }

    @Override
    public List<ItemElectronic> findAllMobile() {
        return itemElectronicDAO.findAllMobile();
    }


}
