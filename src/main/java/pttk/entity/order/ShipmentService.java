package pttk.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentService extends BaseEntity {
    private String shipUnit;
    private Float shipPrice;
}
