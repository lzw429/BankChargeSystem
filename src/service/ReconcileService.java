package service;

import model.AccountError;
import model.AccountTotal;

import java.util.List;

public interface ReconcileService {
    /**
     * 请求对账
     *
     * @param bankID 银行代码
     * @param date   对账时间
     * @return 对账请求成功 true，对账请求失败 false
     */
    boolean reconcile(String bankID, String date);

    /**
     * @param date   对账时间
     * @param bankID 银行编号
     * @return account_total 表的信息
     */
    List<AccountTotal> accountTotal(String date, String bankID);

    /**
     * @param date   对账时间
     * @param bankID 银行编号
     * @return account_error 表的信息
     */
    List<AccountError> accountError(String date, String bankID);
}
