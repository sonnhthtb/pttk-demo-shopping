package pttk.logic.application.orderDAO.impl;

import pttk.logic.application.BaseDAOImpl;
import pttk.logic.application.orderDAO.ShipmentDAO;
import pttk.logic.application.orderDAO.ShipmentServiceDAO;
import pttk.model.order.Shipment;
import pttk.util.impl.ShipmentMapper;

import java.util.List;

public class ShipmentDAOImpl extends BaseDAOImpl<Shipment> implements ShipmentDAO {

    private final ShipmentServiceDAO shipmentServiceDAO = new ShipmentServiceDAOImpl();

    @Override
    public Shipment findByOrderId(int orderId) {
        String sql = "SELECT * FROM Shipment WHERE OrderID = ?";
        List<Shipment> shipmentList = query(sql, new ShipmentMapper(), orderId);
        Shipment shipment = shipmentList.isEmpty() ? null : shipmentList.get(0);
        if (shipment != null) {
            shipment.setShipmentService(shipmentServiceDAO.findById(shipment.getShipmentService().getId()));
        }
        return shipment;
    }

    @Override
    public void save(Shipment shipment, int orderId) {
        String sql = "INSERT INTO Shipment(ShipmentServiceID, OrderId, AddressReceive) VALUES(?, ?, ?)";
        insert(sql, shipment.getShipmentService().getId(), orderId, shipment.getAddressReceive());
    }
}
