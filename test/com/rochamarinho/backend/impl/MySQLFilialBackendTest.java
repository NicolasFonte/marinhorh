package com.rochamarinho.backend.impl;

import com.rochamarinho.model.Advogado;
import com.rochamarinho.model.Filial;
import com.rochamarinho.utils.BackendException;
import java.util.List;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author nicolas
 */
public class MySQLFilialBackendTest {

    MySQLFilialBackend backend;
    private SessionFactory factory;
    private Session session;
    private AnnotationConfiguration conf;
    private Properties forTest;

    public MySQLFilialBackendTest() {
    }

    @Before
    public void setUp() {

        backend = new MySQLFilialBackend();
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
    public void testThatFilialCanBeCreatedOnMysqlByHibernateBackend() throws BackendException
    {
        Filial toAdd = createDefaultFilial();
        
        String advogadoName = toAdd.getNome();
        backend.create(toAdd);
        
        Filial reloaded = (Filial) session.get(Filial.class, 1L);
        assertEquals(advogadoName, reloaded.getNome());
    }
    
    
    
    @Test
    public void testThatFilialCanBeRemovedOnMysqlByHibernateBackend() throws BackendException
    {
        Filial toRemove = createDefaultFilial();
               
        backend.create(toRemove);
        backend.remove(toRemove);        
        Filial reloaded = (Filial) session.get(Filial.class, 1L);
        
        assertNull(reloaded);
    
    }
    
    @Test
    public void testThatACreatedFilialCanBeReadOnMysqlByHibernateBackend() throws BackendException
    {
        
        Filial toAdd = createDefaultFilial();
        String filialName = toAdd.getNome();
        backend.create(toAdd);    
        
        assertEquals(filialName, backend.read(1L).getNome());
        
    }
    
    @Test
    public void testThatACreatedFilialCanAlsoBeUpdatedOnMysqlByHibernateBackend() throws BackendException
    {
        
        Filial toAdd = createDefaultFilial();
        backend.create(toAdd);   
        
        String updatedName = "advogado" + Math.random();
        toAdd.setNome(updatedName);
        backend.update(toAdd);
        
        assertEquals(updatedName, backend.read(1L).getNome());
    
    }
    
    @Test
    public void testThatFilialsCreatedCanBeListedOnMysqlByHibernateBackend() throws BackendException
    {
        Filial filial1 = createDefaultFilial();
        Filial filial2 = createDefaultFilial();
        Filial filial3 = createDefaultFilial();
        
        backend.create(filial1);
        backend.create(filial2);
        backend.create(filial3);
        
        List<Filial> reloaded = backend.list();
    
        assertEquals(3,reloaded.size());
        
    }
    
    @Test
    public void testeQueUmalistaDeAdvogadosPodeSerRetornadaPorUmaFilial() throws BackendException
    {
        Filial filial = createDefaultFilial();
        
        Advogado adv1 = new Advogado();        
        Advogado adv2 = new Advogado();
        
        adv1.setOab("01236702336");
        adv2.setOab("01236702337");
        
        filial.getAdvogados().add(adv2);
        filial.getAdvogados().add(adv1);
        
        backend.create(filial);
        
        List<Advogado> recarregar = backend.advogadosPorFilial(filial);        
        assertEquals(2,recarregar.size());
        
    }
    
    @Test
    public void MostrarQueFilialPodeSerRecuperadaPeloNome() throws BackendException
    {
        Filial f = createDefaultFilial();
        String nome = f.getNome();
        
        backend.create(f);
        
        Filial recovered = backend.buscarPorNome(nome);
        
        assertEquals(nome, recovered.getNome());
        
    }
    
    
    protected Filial createDefaultFilial()
    {
        String name = "filial " + Math.random();
        Filial defaultOne = new Filial();        
        
        defaultOne.setNome(name);       
        return defaultOne;
    }
    
    
    

    @After
    public void tearDown() {
    }
}
