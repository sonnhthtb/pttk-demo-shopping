package pttk.model.order;


public class Payment {
    private Integer id;
    private Float amount;

    public Payment(Float amount) {
        this.amount = amount;
    }

    public Payment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
