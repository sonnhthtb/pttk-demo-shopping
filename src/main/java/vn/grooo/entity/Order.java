package vn.grooo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity{
    private Date date;
    private String status;
    private Customer customer;
    private Shipment shipment;
    private Payment payment;
    private Cart cart;
}
