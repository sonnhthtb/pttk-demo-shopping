package pttk.logic.application.orderDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.order.Shipment;

public interface ShipmentDAO extends BaseDAO<Shipment> {
    Shipment findByOrderId(int orderId);

    void save(Shipment shipment, int orderId);
}
