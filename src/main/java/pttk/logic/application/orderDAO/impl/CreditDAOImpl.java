package pttk.logic.application.orderDAO.impl;

import pttk.logic.application.BaseDAOImpl;
import pttk.logic.application.orderDAO.CreditDAO;
import pttk.model.order.Credit;
import pttk.util.impl.CreditMapper;

import java.util.List;

public class CreditDAOImpl extends BaseDAOImpl<Credit> implements CreditDAO {
    @Override
    public Credit findByPaymentId(int paymentId) {
        String sql = "SELECT * FROM Credit WHERE PaymentID = ?";
        List<Credit> creditList = query(sql, new CreditMapper(), paymentId);
        Credit credit = creditList.isEmpty() ? null : creditList.get(0);
        return credit;
    }

    @Override
    public void save(Credit credit, int paymentId) {
        String sql = "INSERT INTO Credit(CreditId, Name, PaymentID) VALUES(?, ?, ?)";
        insert(sql, credit.getCreditId(), credit.getName(), paymentId);
    }
}
