package dao.impl;

import Util.DBUtil;
import dao.UserDao;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    private Connection conn = null;

    @Override
    public boolean register(String username, String nickname, String password) {
        return false;
    }

    @Override
    public boolean exist(String username) {
        PreparedStatement stm = null;
        try {
            conn = DBUtil.connectDB(); // 连接数据库
            stm = conn.prepareStatement("SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?");
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                rs.close();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UserDao: 获取用户失败");
            return false;
        } finally {
            DBUtil.safeClose(stm);
            DBUtil.safeClose(conn);
        }
    }

    @Override
    public User find(String username) {
        PreparedStatement stm = null;
        try {
            conn = DBUtil.connectDB(); // 连接数据库
            stm = conn.prepareStatement("SELECT CUSTOMER_ID,PASSWORD,CUSTOMER_NAME,ADDRESS,BALANCE FROM CUSTOMER WHERE CUSTOMER_ID = ?"); // 获取用户基本信息
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("CUSTOMER_ID"), rs.getString("CUSTOMER_NAME"), rs.getString("PASSWORD"), rs.getString("ADDRESS"), rs.getString("BALANCE"));
                rs.close();
                return user;
            } else return null;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UserDao: 获取用户失败");
            return null;
        } finally {
            DBUtil.safeClose(stm);
            DBUtil.safeClose(conn);
        }
    }

    @Override
    public String balanceByCustomerID(String username) {
        PreparedStatement stm = null;
        String res;
        try {
            conn = DBUtil.connectDB(); // 连接数据库
            stm = conn.prepareStatement("SELECT BALANCE FROM CUSTOMER WHERE  CUSTOMER_ID = ?"); // 获取用户基本信息
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                res = rs.getString(1);
                rs.close();
            } else return null;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UserDao: 获取余额失败");
            return null;
        } finally {
            DBUtil.safeClose(stm);
            DBUtil.safeClose(conn);
        }
        return res;
    }
}
