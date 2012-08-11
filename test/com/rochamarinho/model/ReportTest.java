package com.rochamarinho.model;

import com.rochamarinho.backend.AdvogadoBackend;
import com.rochamarinho.backend.impl.MySQLAdvogadoBackend;
import com.rochamarinho.utils.BackendException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author nicolas
 */
public class ReportTest {

    Report report;
    AdvogadoBackend advBackend;

    public ReportTest() {
    }

    @Before
    public void setUp() {

        report = new Report();
        advBackend = mock(AdvogadoBackend.class);

    }

    @Test
    public void testGeracaoRelatorioAnual() throws FileNotFoundException, IOException, BackendException, ParseException {
        when(advBackend.list()).thenReturn(preencherAdvogadosComPagamento());
        report.setBackend(advBackend);
        report.gerarRelatorioAnual(2012);
    }

    @Test
    public void testPagamentosPodemSerFiltradosPorAno() throws Exception {

        Advogado example = gerarAdvogadoComPagamento();
        List<Pagamento> pagsFiltrados = report.filtrarPorAno(2012, example.getHistoricoPagamento());
        assertEquals(12, pagsFiltrados.size());

    }

    public Advogado gerarAdvogadoComPagamento() throws ParseException {

        Date data = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2012");

        Calendar calendar1 = Calendar.getInstance(Locale.ENGLISH);
        calendar1.setTime(data);

        List<Pagamento> pagamentos1 = new ArrayList<Pagamento>();

        for (int i = 0; i < 48; i++) {

            Pagamento each1 = new Pagamento();
            each1.setDataPagamento(calendar1.getTime());
            each1.setValorPago(100.0);
            pagamentos1.add(each1);
            calendar1.add(Calendar.MONTH, 1);

        }

        Advogado adv = new Advogado();
        adv.setHistoricoPagamento(pagamentos1);

        return adv;
    }

    public List<Advogado> preencherAdvogadosComPagamento() throws ParseException {

        List<Advogado> advogados = new ArrayList<Advogado>();

        Date data = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2010");

        Calendar calendar1 = Calendar.getInstance(Locale.ENGLISH);
        calendar1.setTime(data);
        
        Calendar calendar2 = Calendar.getInstance(Locale.ENGLISH);
        calendar2.setTime(data);
        calendar2.add(Calendar.YEAR,1);
        
        List<Pagamento> pagamentos1 = new ArrayList<Pagamento>();
        List<Pagamento> pagamentos2 = new ArrayList<Pagamento>();

        for (int i = 0; i < 48; i++) {

            Pagamento each1 = new Pagamento();
            Pagamento each2 = new Pagamento();
            
            each1.setDataPagamento(calendar1.getTime());
            each1.setValorPago(100.0);
            
            each2.setDataPagamento(calendar2.getTime());
            each2.setValorPago(150.0);
            
            pagamentos1.add(each1);
            pagamentos2.add(each2);
            
            calendar1.add(Calendar.MONTH, 1);
            calendar2.add(Calendar.MONTH, 1);
      
        }

        Advogado adv1 = new Advogado();
        adv1.setHistoricoPagamento(pagamentos1);
        adv1.setNome("advogado1");

        Advogado adv2 = new Advogado();
        adv2.setHistoricoPagamento(pagamentos2);
        adv2.setNome("advogado2");
        
        
        List<Advogado> lista = new ArrayList<Advogado>();
        
        lista.add(adv1);
        lista.add(adv2);
        
        return lista;
        
    }
    
    @Test
    public void importarDados()
    {
        
        
        
    
    }
    
    
        @After
    public void tearDown() {
    }
}
