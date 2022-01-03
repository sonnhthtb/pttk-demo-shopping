package pttk.logic.application.orderDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.order.Cash;

public interface CashDAO extends BaseDAO<Cash> {
    Cash findByPaymentId(int paymentId);

    void save(Cash cash, int paymentId);
}
