package pttk.entity.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.book.ItemBook;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineItemBook {
    private int id;
    private int quantity;
    private ItemBook itemBook;
}
