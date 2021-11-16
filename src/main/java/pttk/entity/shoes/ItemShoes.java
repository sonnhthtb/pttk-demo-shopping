package pttk.entity.shoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.BaseEntity;
import pttk.entity.shoes.Shoes;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemShoes extends BaseEntity {
    private Float price;
    private String imageUrl;
    private Shoes shoes;
}
