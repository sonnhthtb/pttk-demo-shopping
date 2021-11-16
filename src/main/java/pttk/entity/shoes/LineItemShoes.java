package pttk.entity.shoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.shoes.ItemShoes;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItemShoes {
    private int id;
    private int quantity;
    private ItemShoes itemShoes;
}
