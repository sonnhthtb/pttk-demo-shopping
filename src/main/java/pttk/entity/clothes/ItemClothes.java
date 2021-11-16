package pttk.entity.clothes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.BaseEntity;
import pttk.entity.clothes.Clothes;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemClothes extends BaseEntity {
    private Float price;
    private String imageUrl;
    private Clothes clothes;
}
