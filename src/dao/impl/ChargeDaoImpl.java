package dao.impl;

import Util.DBUtil;
import dao.ChargeDao;
import model.Bill;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChargeDaoImpl implements ChargeDao {
    private Connection conn = null;

    @Override
    public List<Bill> toBePaid(String CUSTOMER_ID) {
        CallableStatement callStm = null;
        List<Bill> billList = new CopyOnWriteArrayList<>();
        try {
            conn = DBUtil.connectDB(); // 连接数据库
            callStm = conn.prepareCall("BEGIN PACKAGE_QUERYFEE_CURSOR.queryFee(?,?); END;");
            callStm.registerOutParameter(2, OracleTypes.CURSOR);
            callStm.setString(1, CUSTOMER_ID);
            callStm.execute();

            // 返回结果集
            ResultSet rset = (ResultSet) callStm.getObject(2);

            // 确定结果集的每一行中的列数
            ResultSetMetaData rsetMeta = rset.getMetaData();
            int count = rsetMeta.getColumnCount();

            // 返回结果
            while (rset.next()) {
                Bill bill = new Bill(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7));
                billList.add(bill);
                // 打印结果
                String rsetRow = "";
                for (int i = 1; i <= count; i++) {
                    rsetRow = rsetRow + " " + rset.getString(i);
                }
                System.out.println(rsetRow);
            }
            rset.close();
            System.out.println("ChargeDao: 获取待支付账单成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ChargeDao: 获取待支付账单失败");
        } finally {
            DBUtil.safeClose(callStm);
            DBUtil.safeClose(conn);
        }
        return billList;
    }

    @Override
    public boolean payByPr(String bankID, String prID, String amount) {
        CallableStatement callStm = null;
        boolean res = false;
        try {
            conn = DBUtil.connectDB(); // 连接数据库
            callStm = conn.prepareCall("BEGIN payment_pr(?,?,?,?); END;");
            callStm.registerOutParameter(4, OracleTypes.BOOLEAN);
            callStm.setString(1, bankID);
            callStm.setString(2, prID);
            callStm.setString(3, amount);

            callStm.execute();

            // 返回结果
            res = callStm.getBoolean(4);

            System.out.println("ChargeDao: payByPr 请求数据库成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ChargeDao: payByPr 请求数据库失败");
        } finally {
            DBUtil.safeClose(callStm);
            DBUtil.safeClose(conn);
        }
        return res;
    }

    @Override
    public boolean payReversal() {
        return false;
    }
}
