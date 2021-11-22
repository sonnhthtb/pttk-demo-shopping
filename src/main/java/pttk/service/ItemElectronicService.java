package pttk.service;


import pttk.model.electronic.Computer;
import pttk.model.electronic.ItemElectronic;
import pttk.model.electronic.Mobile;

import java.util.List;

public interface ItemElectronicService {
    ItemElectronic findElectronicById(int ItemElectronicId);
    List<ItemElectronic> findAll();
    List<ItemElectronic> findAllItemElectronic(int limit, int offset);
    List<ItemElectronic> findAllComputer();
    List<ItemElectronic> findAllMobile();
    Mobile findMobile(int itemElectronicId);
    Computer findComputer(int itemElectronicId);
}
