package pttk.model.order;

public class ShipmentService {
    private Integer id;
    private String shipUnit;
    private Float shipPrice;

    public ShipmentService(String shipUnit, Float shipPrice) {
        this.shipUnit = shipUnit;
        this.shipPrice = shipPrice;
    }

    public ShipmentService() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShipUnit() {
        return shipUnit;
    }

    public void setShipUnit(String shipUnit) {
        this.shipUnit = shipUnit;
    }

    public Float getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(Float shipPrice) {
        this.shipPrice = shipPrice;
    }
}
