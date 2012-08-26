package com.rochamarinho.model;

import org.junit.Ignore;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Workbook;
import com.rochamarinho.backend.AdvogadoBackend;
import com.rochamarinho.backend.impl.MySQLAdvogadoBackend;
import com.rochamarinho.backend.impl.MySQLFilialBackend;
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
import org.apache.poi.ss.usermodel.ExcelStyleDateFormatter;
import org.junit.After;
import org.junit.Before;
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
    @Ignore
    public void testGeracaoRelatorioAnual() throws FileNotFoundException, IOException, BackendException, ParseException {
        when(advBackend.list()).thenReturn(preencherAdvogadosComPagamento());
        report.setBackend(advBackend);
        report.gerarRelatorioAnual(2012);
    }

    @Test
    @Ignore
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
        calendar2.add(Calendar.YEAR, 1);

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
    public void importarDados() throws FileNotFoundException, IOException, InvalidFormatException, ParseException, BackendException {



        Advogado adv;
        MySQLAdvogadoBackend realAdvogadoBackend = new MySQLAdvogadoBackend();
        MySQLFilialBackend realFilialBackend = new MySQLFilialBackend();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        InputStream inp = new FileInputStream("rhlibs/DadosRH.xlsx");

        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);

        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            adv = new Advogado();
            System.out.println(i);
            Row row = sheet.getRow(i);

            String nome = row.getCell(0).getRichStringCellValue().getString();
            String uf = row.getCell(1).getRichStringCellValue().getString();
            double oab = row.getCell(2).getNumericCellValue();
            String email = row.getCell(3).getRichStringCellValue().getString();
            double distribuicao = row.getCell(4).getNumericCellValue();
            String taxa = row.getCell(5).getRichStringCellValue().getString();
            String nascimento = "02/12/2000";//row.getCell(6).getRichStringCellValue().getString();
            String associacao = "02/12/2000";//row.getCell(7).getRichStringCellValue().getString();
            String filial = row.getCell(8).getRichStringCellValue().getString();

            List<ValorMes> tabelaDeValores = gerarValores(row);
            List<Pagamento> valoresPagos = gerarHistoricoDePagamento(row);

            System.out.println("advogado " + nome + "||"
                    + uf + "||" + oab + "||" + email + "||"
                    + distribuicao + "||" + taxa + "||" + nascimento + "||" + associacao + "||" + filial + "||");


            adv.setNome(nome);
            adv.setUf(uf);
            adv.setOab(oab + uf);
            adv.setAtivo(true);
            adv.setEmail(email);
            adv.setDistribuicao(distribuicao);
            adv.setUsaTaxa(true);
            adv.setAssociacao(formatter.parse(associacao));
            adv.setNascimento(formatter.parse(nascimento));


            adv.setValores(tabelaDeValores);
            adv.setHistoricoPagamento(valoresPagos);
            
            Filial f = realFilialBackend.buscarPorNome(filial);
            f.addAdvogado(adv);
            realFilialBackend.update(f);


        }



    }

    protected List<ValorMes> gerarValores(Row row) {
        List<ValorMes> valores = new ArrayList<ValorMes>();
        valores.add(new ValorMes("janeiro", row.getCell(10).getNumericCellValue()));
        valores.add(new ValorMes("fevereiro", row.getCell(11).getNumericCellValue()));
        valores.add(new ValorMes("marco", row.getCell(12).getNumericCellValue()));
        valores.add(new ValorMes("abril", row.getCell(13).getNumericCellValue()));
        valores.add(new ValorMes("maio", row.getCell(14).getNumericCellValue()));
        valores.add(new ValorMes("junho", row.getCell(15).getNumericCellValue()));
        valores.add(new ValorMes("julho", row.getCell(16).getNumericCellValue()));
        valores.add(new ValorMes("agosto", row.getCell(16).getNumericCellValue()));
        return valores;
    }

    protected List<Pagamento> gerarHistoricoDePagamento(Row row) throws ParseException {

        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("05/01/2012");
        calendar.setTime(date);

        List<Pagamento> pagamentos = new ArrayList<Pagamento>();
        pagamentos.add(new Pagamento(calendar.getTime(), row.getCell(10).getNumericCellValue()));
        calendar.add(Calendar.MONTH, 1);
        pagamentos.add(new Pagamento(calendar.getTime(), row.getCell(11).getNumericCellValue()));
        calendar.add(Calendar.MONTH, 1);
        pagamentos.add(new Pagamento(calendar.getTime(), row.getCell(12).getNumericCellValue()));
        calendar.add(Calendar.MONTH, 1);
        pagamentos.add(new Pagamento(calendar.getTime(), row.getCell(13).getNumericCellValue()));
        calendar.add(Calendar.MONTH, 1);
        pagamentos.add(new Pagamento(calendar.getTime(), row.getCell(14).getNumericCellValue()));
        calendar.add(Calendar.MONTH, 1);
        pagamentos.add(new Pagamento(calendar.getTime(), row.getCell(15).getNumericCellValue()));
        calendar.add(Calendar.MONTH, 1);
        pagamentos.add(new Pagamento(calendar.getTime(), row.getCell(16).getNumericCellValue()));
        calendar.add(Calendar.MONTH, 1);
        pagamentos.add(new Pagamento(calendar.getTime(), row.getCell(16).getNumericCellValue()));

        return pagamentos;
    }

    @After
    public void tearDown() {
    }
}
