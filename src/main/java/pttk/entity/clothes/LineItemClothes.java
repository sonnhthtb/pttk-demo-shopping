package pttk.entity.clothes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.clothes.ItemClothes;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItemClothes {
    private int id;
    private int quantity;
    private ItemClothes itemClothes;
}
