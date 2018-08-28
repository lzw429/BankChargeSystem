package dao.impl;

import Util.DBUtil;
import dao.ReconcileDao;
import model.AccountError;
import model.AccountTotal;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ReconcileDaoImpl implements ReconcileDao {
    private Connection conn = null;

    @Override
    public boolean reconcile(Date date) {
        return false;
    }

    @Override
    public List<AccountTotal> accountTotal(java.sql.Date date) {
        CallableStatement callStm = null;
        List<AccountTotal> accountTotalList = new CopyOnWriteArrayList<>();
        try {
            conn = DBUtil.connectDB(); // 连接数据库
            callStm = conn.prepareCall("BEGIN PACKAGE_QUERY_ACCOUNT_TOTAL.QUERY_ACCOUNT_TOTAL(?,?);END;");

            callStm.registerOutParameter(2, OracleTypes.CURSOR);
            callStm.setDate(1, date);

            callStm.execute();

            // 返回结果集
            ResultSet rset = (ResultSet) callStm.getObject(2);

            // 确定结果集的每一行中的列数
            ResultSetMetaData rsetMeta = rset.getMetaData();
            int count = rsetMeta.getColumnCount();

            // 返回结果
            while (rset.next()) {
                AccountTotal accountTotal = new AccountTotal();
                accountTotalList.add(accountTotal);
                // 打印结果
                String rsetRow = "";
                for (int i = 1; i <= count; i++) {
                    rsetRow = rsetRow + " " + rset.getString(i);
                }
                System.out.println(rsetRow);
            }

            System.out.println("ChargeDao: 获取对总账表成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ChargeDao: 获取对总账表失败");
        } finally {
            DBUtil.safeClose(callStm);
            DBUtil.safeClose(conn);
        }
        return null;
    }

    @Override
    public List<AccountError> accountError(Date date) {
        return null;
    }
}
