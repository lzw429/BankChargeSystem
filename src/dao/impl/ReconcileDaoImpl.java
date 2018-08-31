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
    public boolean reconcile(String bankID, java.sql.Date date) {
        PreparedStatement stm = null;
        try {
            conn = DBUtil.connectDB();
            stm = conn.prepareStatement("BEGIN RECONCILE(?,?); END;");
            stm.setString(1, bankID);
            stm.setDate(2, date);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ReconcileDao: " + "请求数据库异常");
            return false;
        } finally {
            DBUtil.safeClose(stm);
            DBUtil.safeClose(conn);
        }
        System.out.println("ReconcileDao: " + "请求数据库正常");
        return true;
    }

    @Override
    public List<AccountTotal> accountTotal(java.sql.Date date, String bankID) {
        CallableStatement callStm = null;
        List<AccountTotal> accountTotalList = new CopyOnWriteArrayList<>();
        try {
            conn = DBUtil.connectDB(); // 连接数据库
            callStm = conn.prepareCall("BEGIN PACKAGE_QUERY_ACCOUNT_TOTAL.QUERY_ACCOUNT_TOTAL(?,?,?);END;");

            callStm.registerOutParameter(3, OracleTypes.CURSOR);
            callStm.setDate(1, date);
            callStm.setString(2, bankID);

            callStm.execute();

            // 返回结果集
            ResultSet rset = (ResultSet) callStm.getObject(3);

            // 确定结果集的每一行中的列数
            ResultSetMetaData rsetMeta = rset.getMetaData();
            int count = rsetMeta.getColumnCount();

            // 返回结果
            while (rset.next()) {
                AccountTotal accountTotal = new AccountTotal(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8));
                accountTotalList.add(accountTotal);
                // 打印结果
                String rsetRow = "";
                for (int i = 1; i <= count; i++) {
                    rsetRow = rsetRow + " " + rset.getString(i);
                }
                System.out.println(rsetRow);
            }
            rset.close();
            System.out.println("ChargeDao: 获取对总账表 成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ChargeDao: 获取对总账表 失败");
        } finally {
            DBUtil.safeClose(callStm);
            DBUtil.safeClose(conn);
        }
        return accountTotalList;
    }

    @Override
    public List<AccountError> accountError(Date date, String bankID) {
        CallableStatement callStm = null;
        List<AccountError> accountErrorList = new CopyOnWriteArrayList<>();
        try {
            conn = DBUtil.connectDB(); // 连接数据库
            callStm = conn.prepareCall("BEGIN PACKAGE_QUERY_ACCOUNT_ERROR.QUERY_ACCOUNT_ERROR(?,?,?);END;");

            callStm.registerOutParameter(3, OracleTypes.CURSOR);
            callStm.setDate(1, date);
            callStm.setString(2, bankID);

            callStm.execute();

            // 返回结果集
            ResultSet rset = (ResultSet) callStm.getObject(3);

            // 确定结果集的每一行中的列数
            ResultSetMetaData rsetMeta = rset.getMetaData();
            int count = rsetMeta.getColumnCount();

            // 返回结果
            while (rset.next()) {
                AccountError accountError = new AccountError(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8));
                if (accountError.getBankAmount() == null)
                    accountError.setBankAmount("无");
                if (accountError.getCorpAmount() == null)
                    accountError.setCorpAmount("无");
                accountErrorList.add(accountError);
                // 打印结果
                String rsetRow = "";
                for (int i = 1; i <= count; i++) {
                    rsetRow = rsetRow + " " + rset.getString(i);
                }
                System.out.println(rsetRow);
            }
            rset.close();
            System.out.println("ChargeDao: 获取对账异常表 成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ChargeDao: 获取对账异常表 失败");
        } finally {
            DBUtil.safeClose(callStm);
            DBUtil.safeClose(conn);
        }
        return accountErrorList;
    }
}
