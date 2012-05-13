package com.rochamarinho.backend.impl;

import com.rochamarinho.model.Taxa;
import com.rochamarinho.utils.BackendException;
import java.util.Properties;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicolas
 */
public class MySQLTaxaBackendTest {
    
    MySQLTaxaBackend backend;
    private SessionFactory factory;
    private Session session;
    private AnnotationConfiguration conf;
    private Properties forTest;

    
    public MySQLTaxaBackendTest() {
        

    }
    
    @Before
    public void setUp() {
        
        backend = new MySQLTaxaBackend();
        conf = new AnnotationConfiguration();

        forTest = new Properties();
        //we need mode create in the tests!
        forTest.put("hibernate.hbm2ddl.auto", "create");
        forTest.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        forTest.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        forTest.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/marinhorh");
        forTest.put("hibernate.connection.username", "root");
        forTest.put("show_sql", "true");
        forTest.put("format_sql", "true");

        conf.configure();
        conf.setProperties(forTest);

        factory = conf.buildSessionFactory();
        session = factory.openSession();
    }
    
    @Test
    public void testThatTaxaCanBeCreatedOnMysqlByHibernateBackend() throws BackendException
    {
        Taxa toAdd = criarValorPadraoParaTaxa();
        
        double valorTaxa = toAdd.getValor();
        backend.create(toAdd);
        
        Taxa reloaded = (Taxa) session.get(Taxa.class, 1L);
        assertEquals(valorTaxa, reloaded.getValor(),0.1);
    }
    
    @Test
    public void testThatACreatedTaxaCanBeReadOnMysqlByHibernateBackend() throws BackendException
    {
        
        Taxa toAdd = criarValorPadraoParaTaxa();
        double taxaValor = toAdd.getValor();
        backend.create(toAdd);    
        
        assertEquals(taxaValor, backend.read(1L).getValor(),0.1);
        
    }
    
    @Test
    public void testThatACreatedFilialCanAlsoBeUpdatedOnMysqlByHibernateBackend() throws BackendException
    {
        
        Taxa toAdd = criarValorPadraoParaTaxa();
        backend.create(toAdd);   
        
        double updatedValor = 1.0 + Math.random();
        toAdd.setValor(updatedValor);
        backend.update(toAdd);
        
        assertEquals(updatedValor, backend.read(1L).getValor(),0.1);
    
    }
    
    protected Taxa criarValorPadraoParaTaxa()
    {
        double valor = 4.0 + Math.random();
        Taxa defaultOne = new Taxa();        
        
        defaultOne.setValor(valor);       
        return defaultOne;
    }
    
    @After
    public void tearDown() {
    }

}
