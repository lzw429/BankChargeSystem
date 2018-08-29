package service.impl;

import Util.DateUtil;
import dao.ReconcileDao;
import dao.impl.ReconcileDaoImpl;
import model.AccountError;
import model.AccountTotal;
import service.ReconcileService;

import java.util.List;

public class ReconcileServiceImpl implements ReconcileService {
    private ReconcileDao reconcileDao = new ReconcileDaoImpl();

    @Override
    public boolean reconcile(String bankID, String date) {
        return reconcileDao.reconcile(bankID, DateUtil.strToSqlDate(date));
    }

    @Override
    public List<AccountTotal> accountTotal(String date) {
        return reconcileDao.accountTotal(DateUtil.strToSqlDate(date));
    }

    @Override
    public List<AccountError> accountError(String date) {
        return reconcileDao.accountError(DateUtil.strToSqlDate(date));
    }
}
