package pttk.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullName extends BaseEntity {
    private String firstName;
    private String middleName;
    private String lastName;
}
