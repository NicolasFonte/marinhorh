package com.rochamarinho.backend.impl;

import java.util.List;
import com.rochamarinho.utils.BackendException;
import com.rochamarinho.model.Advogado;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicolas
 */
public class MySQLAdvogadoBackendTest {
    
    MySQLAdvogadoBackend backend;
    
    private SessionFactory factory;
    private Session session;
    private AnnotationConfiguration conf;
    private Properties forTest;
    
    public MySQLAdvogadoBackendTest() {
    }

    
    @Before
    public void setUp() {
        
        backend = new MySQLAdvogadoBackend();
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
    public void testThatAdvogadoCanBeCreatedOnMysqlByHibernateBackend() throws BackendException
    {
        Advogado toAdd = createDefaultAdvogado();
        
        String advogadoName = toAdd.getNome();
        backend.create(toAdd);
        
        Advogado reloaded = (Advogado) session.get(Advogado.class, 1L);
        assertEquals(advogadoName, reloaded.getNome());
    }
    
    
    
    @Test
    public void testThatAdvogadoCanBeRemovedOnMysqlByHibernateBackend() throws BackendException
    {
        Advogado toRemove = createDefaultAdvogado();
               
        backend.create(toRemove);
        backend.remove(toRemove);        
        Advogado reloaded = (Advogado) session.get(Advogado.class, 1L);
        
        assertNull(reloaded);
    
    }
    
    @Test
    public void testThatACreatedAdvogadoCanBeReadOnMysqlByHibernateBackend() throws BackendException
    {
        
        Advogado toAdd = createDefaultAdvogado();
        String advogadoName = toAdd.getNome();
        backend.create(toAdd);    
        
        assertEquals(advogadoName, backend.read(1L).getNome());
        
    }
    
    @Test
    public void testThatACreatedAdvogadoCanAlsoBeUpdatedOnMysqlByHibernateBackend() throws BackendException
    {
        
        Advogado toAdd = createDefaultAdvogado();
        backend.create(toAdd);   
        
        String updatedName = "advogado" + Math.random();
        toAdd.setNome(updatedName);
        backend.update(toAdd);
        
        assertEquals(updatedName, backend.read(1L).getNome());
    
    }
    
    @Test
    public void testThatAdvogadosCreatedCanBeListedOnMysqlByHibernateBackend() throws BackendException
    {
        Advogado adv1 = createDefaultAdvogado();
        Advogado adv2 = createDefaultAdvogado();
        adv2.setCpf("123435");
        Advogado adv3 = createDefaultAdvogado();
        adv3.setCpf("1234353");
        
        backend.create(adv1);
        backend.create(adv2);
        backend.create(adv3);
        
        List<Advogado> reloaded = backend.list();
    
        assertEquals(3,reloaded.size());
        
    }
    
    @Test
    public void testThatAdvogadosCanBeRetriviedByCpf() throws BackendException
    {
        Advogado adv1 = createDefaultAdvogado();
        
        
        backend.create(adv1);
        Advogado reloaded = backend.byCpf("01236702336");
        assertNotNull(reloaded);
        
        
    }
    
    @Test
    public void testeQueOAdvogadoSabeGuardarSeusSalariosEPagamentos() throws BackendException
    {
        Advogado adv = createDefaultAdvogado();
        
        adv.setTaxa(10);
        adv.setDistribuicao(1000);
        adv.gerarSalarios();
        
        
        backend.create(adv);        
        
        List<Advogado> reloaded = backend.list();
        assertEquals(1,reloaded.size());
        
        Advogado reloadedOne = reloaded.get(0);
        
        assertEquals(13200.0,reloadedOne.getSalarioTotal(),0.5);
        
        
    }
     
    protected Advogado createDefaultAdvogado()
    {
        String name = "advogado " + Math.random();
        Advogado defaultOne = new Advogado();
        defaultOne.setCpf("01236702336");
        
        defaultOne.setNome(name);       
        return defaultOne;
    }
    
    
}
