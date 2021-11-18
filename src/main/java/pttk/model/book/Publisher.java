package pttk.model.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.electronic.Electronic;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher extends Electronic {
    private String name;
    private String address;
}
