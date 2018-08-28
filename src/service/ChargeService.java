package service;

import model.Bill;

import java.util.List;

public interface ChargeService {
    /**
     * @param CUSTOMER_ID 用户编号
     * @return 返回待支付账单
     */
    List<Bill> toBePaid(String CUSTOMER_ID);
}
