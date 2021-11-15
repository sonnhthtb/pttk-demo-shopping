package pttk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullName extends BaseEntity{
    private String firstName;
    private String middleName;
    private String lastName;
}
