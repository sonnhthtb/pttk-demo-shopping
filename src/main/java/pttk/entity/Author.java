package pttk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author extends BaseEntity{
    private String name;
    private String biography;
    private String nation;
}
