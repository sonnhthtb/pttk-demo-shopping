package vn.grooo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment extends BaseEntity{
    private String addressReceive;
    private ShipmentService shipmentService;
}
