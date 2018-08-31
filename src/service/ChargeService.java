package service;

import model.Balance;
import model.Bill;
import model.PayLog;

import java.util.List;

public interface ChargeService {
    /**
     * @param CUSTOMER_ID 用户编号
     * @return 返回待支付账单
     */
    List<Bill> toBePaid(String CUSTOMER_ID);

    /**
     * @param bankID     银行代码
     * @param prID       账单流水号
     * @param amount     支付金额
     * @param customerID 用户编号
     * @return 支付成功 true，失败 false
     */
    boolean payByPr(String bankID, String prID, String amount, String customerID);

    /**
     * @param username 用户编号
     * @return 支付记录
     */
    List<PayLog> payLogByCustomerID(String username);

    /**
     * @param customerID 用户编号
     * @param btID       银行转账流水号
     * @return 冲正成功 true，失败 false
     */
    boolean payReverse(String customerID, String btID);

    /**
     * @param customerID 用户编号
     * @param balanceID  收支记录编号
     * @return 冲正成功 true，失败 false
     */
    boolean payReverseBalance(String customerID, String balanceID);

    /**
     * @param username 用户编号
     * @return 用户余额收支记录
     */
    List<Balance> balanceByCustomerID(String username);
}
