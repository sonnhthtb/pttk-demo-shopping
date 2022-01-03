package pttk.model.order;

public class Shipment {
    private Integer id;
    private String addressReceive;
    private ShipmentService shipmentService;

    public Shipment(String addressReceive, ShipmentService shipmentService) {
        this.addressReceive = addressReceive;
        this.shipmentService = shipmentService;
    }

    public Shipment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressReceive() {
        return addressReceive;
    }

    public void setAddressReceive(String addressReceive) {
        this.addressReceive = addressReceive;
    }

    public ShipmentService getShipmentService() {
        return shipmentService;
    }

    public void setShipmentService(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }
}
