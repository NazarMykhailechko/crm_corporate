package ua.crm.corporate.dao;

import ua.crm.corporate.exceptions.NotFoundCurrencyException;
import ua.crm.corporate.model.CurrencyRate;

import java.util.Currency;
import java.util.List;

public interface CurrencyDao {

    void create(CurrencyRate currencyRate);
    CurrencyRate find(long id);
    List<CurrencyRate> findAll();
    void update(long id,CurrencyRate currencyRate);
    CurrencyRate delete(long id);
    void close();

}
