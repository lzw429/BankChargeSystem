package service.impl;

import dao.ChargeDao;
import dao.impl.ChargeDaoImpl;
import model.Balance;
import model.Bill;
import model.PayLog;
import service.ChargeService;

import java.util.List;

public class ChargeServiceImpl implements ChargeService {
    private ChargeDao chargeDao = new ChargeDaoImpl();

    @Override
    public List<Bill> toBePaid(String CUSTOMER_ID) {
        return chargeDao.toBePaid(CUSTOMER_ID);
    }

    @Override
    public boolean payByPr(String bankID, String prID, String amount, String customerID) {
        return chargeDao.payByPr(bankID, prID, amount, customerID);
    }

    @Override
    public List<PayLog> payLogByCustomerID(String username) {
        return chargeDao.payLogByCustomerID(username);
    }

    @Override
    public boolean payReverse(String customerID, String btID) {
        return chargeDao.payReverse(customerID, btID);
    }

    @Override
    public boolean payReverseBalance(String customerID, String balanceID) {
        return chargeDao.payReverseBalance(customerID, balanceID);
    }

    @Override
    public List<Balance> balanceByCustomerID(String username) {
        return chargeDao.balanceByCustomerID(username);
    }
}
