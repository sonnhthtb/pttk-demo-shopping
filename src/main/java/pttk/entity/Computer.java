package pttk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computer extends BaseEntity{
    private String size;
    private String ram;
    private String power;
    private String rom;
}
