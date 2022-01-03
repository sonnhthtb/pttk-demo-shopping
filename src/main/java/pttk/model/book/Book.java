package pttk.model.book;


public class Book {
    private Integer id;
    private String title;
    private String type;
    private Integer quantity;
    private String size;
    private String description;
    private Publisher publisher;
    private Author author;

    public Book() {
    }

    public Book(Integer id, String title, String type, Integer quantity, String size, String description, Publisher publisher, Author author) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.quantity = quantity;
        this.size = size;
        this.description = description;
        this.publisher = publisher;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
