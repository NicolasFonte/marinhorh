package com.rochamarinho.backend.impl;

import com.rochamarinho.backend.FilialBackend;
import com.rochamarinho.model.Advogado;
import com.rochamarinho.model.Filial;
import com.rochamarinho.utils.BackendException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nicolas
 */
public class MySQLFilialBackend implements FilialBackend {

    
    private SessionFactory factory;
    private Session session;

    public MySQLFilialBackend() {
        
        AnnotationConfiguration conf = new AnnotationConfiguration();
        conf.configure();
        factory = conf.buildSessionFactory();
        session = factory.openSession();
    
    }
    
    
    
    @Override
    public Filial update(Filial object) throws BackendException {
        
        Filial updatedOne = null;
        try {
        Transaction tx = session.beginTransaction();
        updatedOne = (Filial) session.merge(object);
        tx.commit();            
        } catch( HibernateException ex )
        {
            throw new BackendException("hibernate problem");
        }
        
        return updatedOne;
        
        
    }

    @Override
    public void create(Filial object) throws BackendException {
        Transaction tx = session.beginTransaction();
        session.save(object);
        tx.commit(); 
    }

    @Override
    public void remove(Filial object) throws BackendException {
        Transaction tx = session.beginTransaction();
        session.delete(object);
        tx.commit();
    }

    @Override
    public Filial read(Long id) throws BackendException {
        Transaction tx = session.beginTransaction();
        Filial reloaded = (Filial) session.get(Filial.class, id);
        tx.commit();
        return reloaded;
    }

    @Override
    public List<Filial> list() throws BackendException {
        Transaction tx = session.beginTransaction();
        List<Filial> list = session.createCriteria(Filial.class).add(Restrictions.eq("ativo", true)).list();
        tx.commit();

        return list;
    }

    @Override
    public List<Advogado> advogadosPorFilial(Filial filial) throws BackendException {
        
         Filial f = read(filial.getId());         
         return f.getAdvogados();       
    }
    
    @Override
    public void addAdvogadoNaFilial(Filial filial, Advogado advogado) throws BackendException
    {       
        Filial f = read(filial.getId());        
        f.getAdvogados().add(advogado);        
        update(f);        
    }
    
    @Override
    public Filial buscarPorNome(String nome) throws BackendException
    {
        Transaction tx = session.beginTransaction();
        Filial filial = (Filial) session.createCriteria(Filial.class).add(Restrictions.eq("nome", nome)).uniqueResult();
        tx.commit();
        return filial;
    }

}
