package pttk.model.book;


public class LineItemBook {
    private Integer id;
    private Integer quantity;
    private ItemBook itemBook;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ItemBook getItemBook() {
        return itemBook;
    }

    public void setItemBook(ItemBook itemBook) {
        this.itemBook = itemBook;
    }
}
