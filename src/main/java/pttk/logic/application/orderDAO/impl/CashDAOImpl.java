package pttk.logic.application.orderDAO.impl;

import pttk.logic.application.BaseDAOImpl;
import pttk.logic.application.orderDAO.CashDAO;
import pttk.model.order.Cash;
import pttk.util.impl.CashMapper;

import java.util.List;

public class CashDAOImpl extends BaseDAOImpl<Cash> implements CashDAO {
    @Override
    public Cash findByPaymentId(int paymentId) {
        String sql = "SELECT * FROM Cash WHERE PaymentID = ?";
        List<Cash> cashList = query(sql, new CashMapper(), paymentId);
        Cash cash = cashList.isEmpty() ? null : cashList.get(0);
        return cash;
    }

    @Override
    public void save(Cash cash, int paymentId) {
        String sql = "INSERT INTO Cash(PaymentId) VALUES(?)";
        insert(sql, paymentId);
    }
}
