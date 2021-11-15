package pttk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemShoes extends BaseEntity{
    private Float price;
    private String imageUrl;
    private Shoes shoes;
}
