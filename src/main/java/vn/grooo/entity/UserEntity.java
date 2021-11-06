package vn.grooo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    private String username;

    private String password;

    private String fullName;

    private String role;
}
