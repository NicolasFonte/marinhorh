package com.rochamarinho.backend.impl;

import com.rochamarinho.backend.TaxaBackend;
import com.rochamarinho.model.Taxa;
import com.rochamarinho.utils.BackendException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author nicolas
 */
public class MySQLTaxaBackend  implements TaxaBackend{

    private SessionFactory factory;
    private Session session;

    public MySQLTaxaBackend() {
    
        AnnotationConfiguration conf = new AnnotationConfiguration();
        conf.configure();
        factory = conf.buildSessionFactory();
        session = factory.openSession();
    }
    
    
    
    @Override
    public void create(Taxa t) throws BackendException {
        Transaction tx = session.beginTransaction();
        session.save(t);
        tx.commit(); 
        
    }

    @Override
    public Taxa update(Taxa t) throws BackendException {
        Taxa updatedOne = null;
        try {
        Transaction tx = session.beginTransaction();
        updatedOne = (Taxa) session.merge(t);
        tx.commit();            
        } catch( HibernateException ex )
        {
            throw new BackendException("hibernate problem");
        }
        
        return updatedOne;
    }

    @Override
    public Taxa read(Long id) throws BackendException {
        Transaction tx = session.beginTransaction();
        Taxa reloaded = (Taxa) session.get(Taxa.class, id);
        tx.commit();
        return reloaded;
    }
    
}
