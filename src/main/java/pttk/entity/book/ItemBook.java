package pttk.entity.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.entity.BaseEntity;
import pttk.entity.book.Book;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemBook extends BaseEntity {
    private Float price;
    private String imageUrl;
    private Book book;
}
