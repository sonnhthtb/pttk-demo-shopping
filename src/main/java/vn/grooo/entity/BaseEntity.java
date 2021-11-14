package vn.grooo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    private Integer id;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Boolean isDeleted;

}
