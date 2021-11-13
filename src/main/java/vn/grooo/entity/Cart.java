package vn.grooo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseEntity{
    private String cartStatus;
    private Float totalPrice;
    private List<ItemBook> itemBookList;
    private List<ItemElectronic> itemElectronicList;
    private List<ItemShoes> itemShoesList;
    private Customer customer;
}
