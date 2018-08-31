package dao.impl;

import Util.DBUtil;
import dao.MeterDao;
import model.MeterLog;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MeterDaoImpl implements MeterDao {
    private Connection conn = null;

    @Override
    public boolean meterRead(java.sql.Date mrDate, String deviceID, String customerID, String mtNumber, String mrID) {
        CallableStatement callStm = null;
        boolean res;
        try {
            conn = DBUtil.connectDB();
            callStm = conn.prepareCall("BEGIN meter_read(?,?,?,?,?,?); END;");
            callStm.setDate(1, mrDate);
            callStm.setString(2, deviceID);
            callStm.setString(3, customerID);
            callStm.setString(4, mtNumber);
            callStm.setString(5, mrID);
            callStm.registerOutParameter(6, OracleTypes.INTEGER);
            callStm.execute();
            res = callStm.getInt(6) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("MeterDao: 抄表到数据库失败");
            return false;
        } finally {
            DBUtil.safeClose(callStm);
            DBUtil.safeClose(conn);
        }
        return res;
    }

    @Override
    public List<MeterLog> meterLog() {
        CallableStatement callStm = null;
        List<MeterLog> meterLogList = new CopyOnWriteArrayList<>();
        try {
            conn = DBUtil.connectDB(); // 连接数据库
            callStm = conn.prepareCall("BEGIN PACKAGE_QUERY_METER_LOG.QUERY_METER_LOG(?); END;");
            callStm.registerOutParameter(1, OracleTypes.CURSOR);
            callStm.execute();

            // 返回结果集
            ResultSet rset = (ResultSet) callStm.getObject(1);

            // 确定结果集的每一行中的列数
            ResultSetMetaData rsetMeta = rset.getMetaData();
            int count = rsetMeta.getColumnCount();

            // 返回结果
            while (rset.next()) {
                MeterLog meterLog = new MeterLog(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6));
                meterLogList.add(meterLog);
                // 打印结果
                StringBuilder rsetRow = new StringBuilder();
                for (int i = 1; i <= count; i++) {
                    rsetRow.append(" ").append(rset.getString(i));
                }
                System.out.println(rsetRow);
            }
            rset.close();
            System.out.println("MeterDao: 获取抄表记录成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("MeterDao: 获取抄表记录失败");
        } finally {
            DBUtil.safeClose(callStm);
            DBUtil.safeClose(conn);
        }
        return meterLogList;
    }
}
