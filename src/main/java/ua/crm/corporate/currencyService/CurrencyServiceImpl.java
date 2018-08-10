package ua.crm.corporate.currencyService;

import ua.crm.corporate.dao.CurrencyDao;
import ua.crm.corporate.dao.CurrencyDaoImpl;
import ua.crm.corporate.model.CurrencyRate;

import java.util.List;

public class CurrencyServiceImpl implements CurrencyService {

    private CurrencyDao currencyDao;

    public CurrencyServiceImpl() {
        this.currencyDao = new CurrencyDaoImpl();
    }

    @Override
    public void create(CurrencyRate currencyRate) {
        currencyDao.create(currencyRate);
    }

    @Override
    public CurrencyRate find(long id) {
        return currencyDao.find(id);
    }

    @Override
    public List<CurrencyRate> findAll() {
        return currencyDao.findAll();
    }

    @Override
    public void update(long id, CurrencyRate currencyRate) {
        currencyDao.update(id, currencyRate);
    }

    @Override
    public CurrencyRate delete(long id) {
        return currencyDao.delete(id);
    }

}
