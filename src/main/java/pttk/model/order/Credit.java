package pttk.model.order;

public class Credit extends Payment {

    private Integer id;
    private String creditId;
    private String name;

    public Credit() {
    }

    public Credit(String creditId, String name) {
        this.creditId = creditId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
