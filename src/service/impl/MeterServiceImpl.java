package service.impl;

import Util.FormatUtil;
import dao.MeterDao;
import dao.impl.MeterDaoImpl;
import model.MeterLog;
import service.MeterService;

import java.util.List;

public class MeterServiceImpl implements MeterService {
    private MeterDao meterDao = new MeterDaoImpl();

    @Override
    public boolean meterRead(String mrDate, String deviceID, String customerID, String mtNumber, String mrID) {
        return meterDao.meterRead(FormatUtil.strToSqlDate(mrDate), deviceID, customerID, mtNumber, mrID);
    }

    @Override
    public List<MeterLog> meterLog() {
        return meterDao.meterLog();
    }
}
