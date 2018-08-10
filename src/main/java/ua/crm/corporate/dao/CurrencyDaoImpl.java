package ua.crm.corporate.dao;

import org.hibernate.HibernateException;
import ua.crm.corporate.exceptions.NotFoundCurrencyException;
import ua.crm.corporate.model.CurrencyRate;

import javax.persistence.*;
import java.util.List;

public class CurrencyDaoImpl implements CurrencyDao{

    private EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("crm_corporate");
    private EntityManager entityManager;

    public CurrencyDaoImpl() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(CurrencyRate currencyRate) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            entityManager.persist(currencyRate);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public CurrencyRate find(long id) {

        CurrencyRate currencyRate = null;
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            currencyRate = entityManager.find(CurrencyRate.class, id);
            if (currencyRate == null) {
                throw new NotFoundCurrencyException("Client not found!!!");
            }
            transaction.commit();
        } catch (NotFoundCurrencyException e) {
            e.printStackTrace();
        }
        return currencyRate;
    }

        @Override
    public List<CurrencyRate> findAll() {
        Query query = entityManager.createQuery
                ("SELECT c FROM CurrencyRate as c", CurrencyRate.class);
        return query.getResultList();
    }

    @Override
    public void update(long id, CurrencyRate currencyRate) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            CurrencyRate founded = entityManager.find(CurrencyRate.class, id);

            founded.setR030(currencyRate.getR030());
            founded.setTxt(currencyRate.getTxt());
            founded.setRate(currencyRate.getRate());
            founded.setExchangedate(currencyRate.getExchangedate());

            entityManager.merge(founded);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public CurrencyRate delete(long id) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            CurrencyRate currencyRate = entityManager.find(CurrencyRate.class,id);
            if (currencyRate!=null) {
                entityManager.remove(currencyRate);
                transaction.commit();
                return currencyRate;
            }
        }catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    @Override
    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
