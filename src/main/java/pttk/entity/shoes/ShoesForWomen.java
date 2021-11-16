package pttk.entity.shoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.shoes.Shoes;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoesForWomen extends Shoes {
    private String size;
    private Integer soleHeight;
}
