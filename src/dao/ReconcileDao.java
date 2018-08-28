package dao;

import model.AccountError;
import model.AccountTotal;

import java.sql.Date;
import java.util.List;

public interface ReconcileDao {
    /**
     * 请求对账
     *
     * @param date 对账时间
     * @return 对账请求成功 true，对账请求失败 false
     */
    boolean reconcile(Date date);

    /**
     * @param date 对账时间
     * @return account_total 表的信息
     */
    List<AccountTotal> accountTotal(Date date);

    /**
     * @param date 对账时间
     * @return account_error 表的信息
     */
    List<AccountError> accountError(Date date);

}
