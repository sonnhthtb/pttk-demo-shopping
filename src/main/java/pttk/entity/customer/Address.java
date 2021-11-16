package pttk.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {
    private String numberHouse;
    private String street;
    private String district;
    private String city;
    private String nation;
}
