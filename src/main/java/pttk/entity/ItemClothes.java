package pttk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemClothes extends BaseEntity{
    private Float price;
    private String imageUrl;
    private Clothes clothes;
}
