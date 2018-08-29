package service.impl;

import Util.DateUtil;
import dao.MeterDao;
import dao.impl.MeterDaoImpl;
import service.MeterService;

public class MeterServiceImpl implements MeterService {
    private MeterDao meterDao = new MeterDaoImpl();

    @Override
    public boolean meterRead(String mrDate, String deviceID, String customerID, String mtNumber, String mrID) {
        return meterDao.meterRead(DateUtil.strToSqlDate(mrDate), deviceID, customerID, mtNumber, mrID);
    }
}
