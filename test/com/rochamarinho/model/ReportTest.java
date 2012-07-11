package com.rochamarinho.model;

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
public class ReportTest {
    
    public ReportTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testRelatorioAnual() throws Exception
    {
        Report.gerarRelatorioAnual(2000);
    }
    
    
    @After
    public void tearDown() {
    }

}
