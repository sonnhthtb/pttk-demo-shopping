package pttk.logic.application.orderDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.order.Payment;

public interface PaymentDAO extends BaseDAO<Payment> {
    Payment findByOrderId(int orderId);

    void save(Payment payment, int orderId);
}
