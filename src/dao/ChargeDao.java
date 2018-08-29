package dao;

import model.Bill;

import java.util.List;

public interface ChargeDao {
    /**
     * @param CUSTOMER_ID 用户编号
     * @return 返回待支付账单
     */
    List<Bill> toBePaid(String CUSTOMER_ID);

    /**
     * @param bankID 银行代码
     * @param prID   账单流水号
     * @param amount 支付金额
     * @return 支付成功 true，失败 false
     */
    boolean payByPr(String bankID, String prID, String amount);


    boolean payReversal();
}
