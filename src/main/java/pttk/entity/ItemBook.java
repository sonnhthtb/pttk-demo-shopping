package pttk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemBook extends BaseEntity{
    private Float price;
    private String imageUrl;
    private Book book;
}
