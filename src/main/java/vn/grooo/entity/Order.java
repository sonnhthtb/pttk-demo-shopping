package vn.grooo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order extends BaseEntity{

    private UserEntity user;

    private List<OrderItem> orderItems;

    private float totalPrice;

    private int totalAmount;

    private String status;

}
