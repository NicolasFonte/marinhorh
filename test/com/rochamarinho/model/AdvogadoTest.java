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
public class AdvogadoTest {
    
    Advogado adv;
    
    public AdvogadoTest() {
    }

    @Before
    public void setUp() {
        adv = new Advogado();
    }
    
    @Test
    public void testeGeracaoDeSalariosParaAdvogadosCorreto()
    {
        adv.setOab("01236702336");
        adv.setDistribuicao(1000);
        adv.setNome("advogado");
        adv.setTaxa(4);
        
        adv.gerarSalarios();
        int i = 1;
        
        for (ValorMes salarioMes : adv.getValores())
        {
            
            System.out.println("salario valor-mes: " + salarioMes.getValor() + " || " + salarioMes.getMes());
            assertTrue(salarioMes.getValor() > 1000.0);
        }
        
                
    }
    
    
    @After
    public void tearDown() {
    }


}
