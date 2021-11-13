package vn.grooo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity{
    private String title;
    private String type;
    private String quantity;
    private String size;
    private String description;
    private Publisher publisher;
    private Author author;
}
