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
    public void testeGeracaoDeSalariosParaAdvogadosCorretoComTaxa()
    {
        adv.setOab("01236702336");
        adv.setDistribuicao(1000);
        adv.setNome("advogado");
        
        adv.gerarSalarios(5.26);
        int i = 1;
        double somaSalarios = 0;
        for (ValorMes salarioMes : adv.getValores())
        {
            somaSalarios += salarioMes.getValor();
            System.out.println("salario valor-mes: " + salarioMes.getValor() + " || " + salarioMes.getMes());
            assertTrue(salarioMes.getValor() > 1000.0);
        }
        
        assertEquals(adv.getSalarioTotal(), somaSalarios, 1.0);
                
    }
    
    @Test
    public void testeGeracaoDeSalariosParaAdvogadosCorretoSemTaxa()
    {
        adv.setOab("01236702336");
        adv.setDistribuicao(1000);
        adv.setNome("advogado");
        
        adv.gerarSalarios(0.0);
        int i = 1;
        double somaSalarios = 0;
        for (ValorMes salarioMes : adv.getValores())
        {
            somaSalarios += salarioMes.getValor();
            System.out.println("salario valor-mes: " + salarioMes.getValor() + " || " + salarioMes.getMes());
            assertTrue(salarioMes.getValor() > 900);
        }
        
        assertEquals(adv.getSalarioTotal(), somaSalarios, 1.0);
                
    }
    
    
    
    @After
    public void tearDown() {
    }


}
