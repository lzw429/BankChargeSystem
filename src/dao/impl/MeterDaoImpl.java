package dao.impl;

import Util.DBUtil;
import dao.MeterDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MeterDaoImpl implements MeterDao {
    private Connection conn = null;

    @Override
    public boolean meterRead(java.sql.Date mrDate, String deviceID, String customerID, String mtNumber, String mrID) {
        PreparedStatement stm = null;
        try {
            conn = DBUtil.connectDB();
            stm = conn.prepareStatement("BEGIN meter_read(?,?,?,?,?); END;");
            stm.setDate(1, mrDate);
            stm.setString(2, deviceID);
            stm.setString(3, customerID);
            stm.setString(4, mtNumber);
            stm.setString(5, mrID);

            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("MeterDao: 抄表到数据库失败");
            return false;
        } finally {
            DBUtil.safeClose(stm);
            DBUtil.safeClose(conn);
        }
        return true;
    }
}
