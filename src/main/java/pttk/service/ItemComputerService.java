package pttk.service;

import pttk.model.electronic.ItemElectronic;

import java.util.List;

public interface ItemComputerService {
    ItemElectronic findComputerById(int ItemElectronicId);
    List<ItemElectronic> findAll();
    List<ItemElectronic> findAllItemElectronic(int limit, int offset);
}
