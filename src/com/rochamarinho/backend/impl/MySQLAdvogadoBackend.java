package com.rochamarinho.backend.impl;

import com.rochamarinho.backend.AdvogadoBackend;
import com.rochamarinho.model.Advogado;
import com.rochamarinho.utils.BackendException;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nicolas
 */
public class MySQLAdvogadoBackend implements AdvogadoBackend {

    private SessionFactory factory;
    private Session session;

    public MySQLAdvogadoBackend() {
    
        AnnotationConfiguration conf = new AnnotationConfiguration();
        conf.configure();
        factory = conf.buildSessionFactory();
        session = factory.openSession();
    
    }
    
    @Override
    public Advogado update(Advogado object) throws BackendException {
        Transaction tx = session.beginTransaction();
        Advogado updatedOne = (Advogado) session.merge(object);
        tx.commit();            
        return updatedOne;
    }

    @Override
    public void create(Advogado object) throws BackendException {
        Transaction tx = session.beginTransaction();
        session.save(object);
        tx.commit();   
    }

    @Override
    public void remove(Advogado object) throws BackendException {
        Transaction tx = session.beginTransaction();
        session.delete(object);
        tx.commit();
    }

    @Override
    public Advogado read(Long id) throws BackendException {
        Transaction tx = session.beginTransaction();
        Advogado reloaded = (Advogado) session.get(Advogado.class, id);
        tx.commit();
        return reloaded;
    }
    
    @Override
    public List<Advogado> list() {
        Transaction tx = session.beginTransaction();
        List<Advogado> list = session.createCriteria(Advogado.class).list();
        tx.commit();
        return list;
    }


    @Override
    public Advogado byOab(String validOab) throws BackendException {
        Transaction tx = session.beginTransaction();
        Advogado adv = (Advogado) session.createCriteria(Advogado.class).add(Restrictions.eq("oab", validOab)).uniqueResult();
        tx.commit();
        return adv;
    }

    @Override
    public Advogado byNome(String nomeParcial) throws BackendException {
        
        Transaction tx = session.beginTransaction();
        Advogado adv = (Advogado) session.createCriteria(Advogado.class).add(Restrictions.like("nome" , "%" + nomeParcial + "%" )).uniqueResult();
        tx.commit();
        return adv;
        
    }
}
