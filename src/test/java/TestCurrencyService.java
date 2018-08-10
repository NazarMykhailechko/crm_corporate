import org.junit.*;
import org.junit.runners.MethodSorters;
import ua.crm.corporate.currencyService.CurrencyService;
import ua.crm.corporate.currencyService.CurrencyServiceImpl;
import ua.crm.corporate.model.CurrencyRate;

import java.util.List;

@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TestCurrencyService {

    private CurrencyService currencyService;

    @Before
    public void init(){
        currencyService = new CurrencyServiceImpl();
    }

    @Test
    public void _1testCreate(){
        currencyService.create(new CurrencyRate(980,"Українська гривня",1.0,"10.08.2018"));
        CurrencyRate currencyRate = currencyService.find(83);
        Assert.assertEquals("Українська гривня",currencyRate.getTxt());
    }

    @Test
    public void _2testFind(){
        CurrencyRate currencyRate = currencyService.find(35);
        Assert.assertEquals("Євро",currencyRate.getTxt());
    }

    @Test
    public void _3testFindAll(){
        List<CurrencyRate> currencyRates = currencyService.findAll();
        Assert.assertTrue(currencyRates.size()==60);
    }

    @Test
    public void _4testUpdate(){
        currencyService.update(83, new CurrencyRate(980,"Український карбованець",5.05,"10.08.2018"));
        Assert.assertEquals("Український карбованець",currencyService.find(83).getTxt());
    }

    @Test
    public void _5testDelete(){
        currencyService.delete(82);
        Assert.assertTrue(currencyService.findAll().size()==59);
    }

    @After
    public void close(){

    }
}
