package pttk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clothes extends BaseEntity{
    private String barcode;
    private String name;
    private String type;
    private Float price;
    private Integer yearOfManufacture;
    private String size;
    private String color;
    private String material;
    private String description;
    private Trademark trademark;
    private Origin origin;
}
