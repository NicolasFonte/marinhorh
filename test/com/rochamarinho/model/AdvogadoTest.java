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
        adv.setCpf("01236702336");
        adv.setDistribuicao(1000);
        adv.setNome("advogado");
        adv.setTaxa(10);
        
        adv.gerarSalarios();
        int i = 1;
        for (Double salario : adv.mesSalario.values())
        {            
            System.out.println("salario mes : " + i + " valor: " + salario);
            i++;
        }
        
        for (Integer indice: adv.mesSalario.keySet())
        {
            System.out.println(indice);
        }
        
                
    }
    
    
    @After
    public void tearDown() {
    }


}
