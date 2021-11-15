package pttk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity{
    private Account account;
    private Address address;
    private FullName fullName;
    private String role;
    private Cart cart;
}
