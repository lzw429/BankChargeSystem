package service.impl;

import Util.FormatUtil;
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
        return reconcileDao.reconcile(bankID, FormatUtil.strToSqlDate(date));
    }

    @Override
    public List<AccountTotal> accountTotal(String date, String bankID) {
        return reconcileDao.accountTotal(FormatUtil.strToSqlDate(date), bankID);
    }

    @Override
    public List<AccountError> accountError(String date, String bankID) {
        return reconcileDao.accountError(FormatUtil.strToSqlDate(date), bankID);
    }
}
