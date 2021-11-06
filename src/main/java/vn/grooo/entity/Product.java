package vn.grooo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    private String name;

    private String image;

    private float price;

    private String description;

    private Category category;

}
