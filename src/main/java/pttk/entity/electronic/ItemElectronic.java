package pttk.entity.electronic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.BaseEntity;
import pttk.entity.electronic.Electronic;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemElectronic extends BaseEntity {
    private Float price;
    private String imageUrl;
    private Electronic electronic;
}
