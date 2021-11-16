package pttk.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.order.Payment;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credit extends Payment {
    private String creditId;
    private String name;
}
