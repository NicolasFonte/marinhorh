package com.rochamarinho.backend.impl;

import com.rochamarinho.backend.PagamentoBackend;
import com.rochamarinho.model.Pagamento;
import com.rochamarinho.utils.BackendException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Order;

/**
 *
 * @author nicolas
 */
public class MySQLPagamentoBackend implements PagamentoBackend {

    private SessionFactory factory;
    private Session session;

    public MySQLPagamentoBackend() {
        AnnotationConfiguration conf = new AnnotationConfiguration();
        conf.configure();
        factory = conf.buildSessionFactory();
        session = factory.openSession();
    }
    
    
    
    
    @Override
    public List<Pagamento> pagamentosPorAno() throws BackendException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Pagamento update(Pagamento object) throws BackendException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Pagamento object) throws BackendException {
        Transaction tx = session.beginTransaction();
        session.save(object);
        tx.commit();  
    }

    @Override
    public void remove(Pagamento object) throws BackendException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Pagamento read(Long id) throws BackendException {
        Transaction tx = session.beginTransaction();
        Pagamento reloaded = (Pagamento) session.get(Pagamento.class, id);
        tx.commit();
        return reloaded;

    }
    
    @Override
    public Pagamento ultimoPagamento() throws BackendException
    {
        Transaction tx = session.beginTransaction();
        List<Pagamento> pgs = session.createCriteria(Pagamento.class).addOrder(Order.desc("id")).list();
        
        if (pgs == null || pgs.isEmpty())
        {
            return null;
        }
        Pagamento pg = pgs.get(0);
        tx.commit();
        return pg;

    }
    
}
