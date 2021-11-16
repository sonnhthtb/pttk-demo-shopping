package pttk.entity.electronic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.electronic.ItemElectronic;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItemElectronic {
    private int id;
    private int quantity;
    private ItemElectronic itemElectronic;
}
