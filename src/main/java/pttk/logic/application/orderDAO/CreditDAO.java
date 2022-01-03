package pttk.logic.application.orderDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.order.Credit;

public interface CreditDAO extends BaseDAO<Credit> {
    Credit findByPaymentId(int paymentId);

    void save(Credit credit, int paymentId);
}
