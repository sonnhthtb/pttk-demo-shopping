package pttk.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.BaseEntity;
import pttk.entity.order.Cart;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {
    private Account account;
    private Address address;
    private FullName fullName;
    private String role;
    private Cart cart;
}
