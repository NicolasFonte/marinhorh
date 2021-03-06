package com.rochamarinho.backend.impl;

import com.rochamarinho.backend.AdvogadoBackend;
import com.rochamarinho.model.Advogado;
import com.rochamarinho.utils.BackendException;
import java.util.List;
import org.hibernate.HibernateException;
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
    public List<Advogado> list() throws BackendException {
        List<Advogado> list = null;

        try {
            Transaction tx = session.beginTransaction();
            list = session.createCriteria(Advogado.class).add(Restrictions.eq("ativo", true)).list();
            tx.commit();
        } catch (HibernateException ex) {
            throw new BackendException("backend problem on list", ex);
        }
        return list;
    }

    
    @Override
    public List<Advogado> listAll() throws BackendException {
        List<Advogado> list = null;

        try {
            Transaction tx = session.beginTransaction();
            list = session.createCriteria(Advogado.class).list();
            tx.commit();
        } catch (HibernateException ex) {
            throw new BackendException("backend problem on list", ex);
        }
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
    public List<Advogado> byNome(String nomeParcial) throws BackendException {

        Transaction tx = session.beginTransaction();
        List<Advogado> advogados = session.createCriteria(Advogado.class).add(Restrictions.like("nome", "%" + nomeParcial + "%")).add(Restrictions.eq("ativo", true)).list();
        tx.commit();

        return advogados;
    }
}
