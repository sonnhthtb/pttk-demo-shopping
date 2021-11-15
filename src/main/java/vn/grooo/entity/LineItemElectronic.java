package vn.grooo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItemElectronic {
    private int id;
    private int quantity;
    private ItemElectronic itemElectronic;
}
