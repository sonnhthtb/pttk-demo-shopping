package pttk.entity;

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
    private List<LineItemBook> lineItemBooks;
    private List<LineItemElectronic> lineItemElectronics;
    private List<LineItemClothes> lineItemClothes;
    private List<LineItemShoes> lineItemShoes;
    private Customer customer;
}
