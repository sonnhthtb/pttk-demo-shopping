package pttk.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.*;
import pttk.entity.book.LineItemBook;
import pttk.entity.clothes.LineItemClothes;
import pttk.entity.customer.Customer;
import pttk.entity.electronic.LineItemElectronic;
import pttk.entity.shoes.LineItemShoes;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseEntity {
    private String cartStatus;
    private Float totalPrice;
    private List<LineItemBook> lineItemBooks;
    private List<LineItemElectronic> lineItemElectronics;
    private List<LineItemClothes> lineItemClothes;
    private List<LineItemShoes> lineItemShoes;
    private Customer customer;
}
