package pttk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shoes extends BaseEntity{
    private String type;
    private String name;
    private Float price;
    private String brand;
    private String color;
    private String origin;
    private String description;
}
