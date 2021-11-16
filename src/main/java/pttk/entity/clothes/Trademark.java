package pttk.entity.clothes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trademark extends BaseEntity {
    private String name;
    private String address;
}
