package pttk.entity.electronic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Electronic extends BaseEntity {
    private String brand;
    private Float price;
    private Float discount;
    private String origin;
    private String description;
    private Computer computer;
    private Mobile mobile;
}
