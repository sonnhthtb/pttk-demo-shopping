package pttk.model.order;


public class Cash extends Payment {
    private Integer id;
    private String cashId;
    private String cashTendered;

    public Cash() {
    }

    public Cash(Integer id, String cashId, String cashTendered) {
        this.id = id;
        this.cashId = cashId;
        this.cashTendered = cashTendered;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCashId() {
        return cashId;
    }

    public void setCashId(String cashId) {
        this.cashId = cashId;
    }

    public String getCashTendered() {
        return cashTendered;
    }

    public void setCashTendered(String cashTendered) {
        this.cashTendered = cashTendered;
    }
}
