package pttk.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment extends BaseEntity {
    private String addressReceive;
    private ShipmentService shipmentService;
}
