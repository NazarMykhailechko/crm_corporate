import org.junit.*;
import org.junit.runners.MethodSorters;
import ua.crm.corporate.currencyUtiles.CurrUtiles;
import ua.crm.corporate.model.CurrencyRate;

import javax.persistence.*;

@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class TestDataBase {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Before
    public void init(){
        entityManagerFactory = Persistence.createEntityManagerFactory("crm_corporate");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    public void _1testCurrencyPersist(){
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        try{
            CurrUtiles.getCurrencies().forEach(entityManager::persist);
            transaction.commit();
            Assert.assertTrue(true);
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            entityManager.close();
        }

    }

    @Test
    public void _2testCurrencyQuery(){
        Query query = entityManager.createQuery("SELECT c FROM CurrencyRate as c", CurrencyRate.class);
        Assert.assertEquals(59,query.getResultList().size());
    }

    @After
    public void close(){
        entityManagerFactory.close();
    }
}
