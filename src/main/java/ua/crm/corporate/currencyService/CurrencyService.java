package ua.crm.corporate.currencyService;

import ua.crm.corporate.model.CurrencyRate;

import java.util.List;

public interface CurrencyService {

    void create(CurrencyRate currencyRate);
    CurrencyRate find(long id);
    List<CurrencyRate> findAll();
    void update(long id, CurrencyRate currencyRate);
    CurrencyRate delete(long id);

}
