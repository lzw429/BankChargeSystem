package dao;

public interface MeterDao {

    /**
     * @param mrDate     抄表日期
     * @param deviceID   设备编号
     * @param customerID 用户编号
     * @param mtNumber   抄表读数
     * @param mrID       抄表员编号
     * @return 抄表成功 true；失败 false
     */
    boolean meterRead(java.sql.Date mrDate, String deviceID, String customerID, String mtNumber, String mrID);
}
