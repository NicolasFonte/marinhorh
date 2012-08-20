package com.rochamarinho.model;

import com.rochamarinho.backend.AdvogadoBackend;
import com.rochamarinho.backend.impl.MySQLAdvogadoBackend;
import com.rochamarinho.utils.BackendException;
import com.rochamarinho.utils.Conexao;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.w3c.tidy.Clean;

/**
 *
 * @author nicolas
 */
public class Report {

    public AdvogadoBackend backend;

    public Report() {
    }

    public AdvogadoBackend getBackend() {
        return backend;
    }

    public void setBackend(AdvogadoBackend backend) {
        this.backend = backend;
    }

    public void gerarRelatorioAdvogadosMensal(String nomeAdvogado, String nomeFilial, String nomeMes) {

        if (nomeAdvogado.equals("Todos") && nomeFilial.equals("Todos")) // sem nome e sem filial
        {
            gerarRelatorioGeralMes(nomeMes);
        } else if (nomeAdvogado.equals("Todos") && !nomeFilial.equals("Todos")) //sem nome e com filial
        {
            gerarRelatorioFilialMes(nomeFilial, nomeMes);
        } else if (!nomeAdvogado.equals("Todos") && !nomeFilial.equals("Todos")) //com nome e com filial
        {
            gerarRelatorioNomeEFilialMes(nomeAdvogado, nomeFilial, nomeMes);

        } else // creio que a unica chance seja com nome e sem filial
        {            
            gerarRelatorioNomeMes(nomeAdvogado, nomeMes);
        }


    }

    protected void gerarRelatorioGeralMes(String nomeMes) {

        JasperReport jasperReport;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mes", nomeMes);

        Connection con = Conexao.getConexao();

        try {
            jasperReport = JasperCompileManager.compileReport("rhlibs/MensalToExcel.jrxml");
            JasperPrint print = JasperFillManager.fillReport(jasperReport, map, con);
            JasperViewer.viewReport(print, false);

        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void gerarRelatorioFilialMes(String nomeFilial, String nomeMes) {
        JasperReport jasperReport;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mes", nomeMes);
        map.put("nomefilial", nomeFilial);

        Connection con = Conexao.getConexao();

        try {
            jasperReport = JasperCompileManager.compileReport("rhlibs/advogadosporfilial.jrxml");
            JasperPrint print = JasperFillManager.fillReport(jasperReport, map, con);
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void gerarRelatorioNomeEFilialMes(String nomeAdvogado, String nomeFilial, String nomeMes) {
        JasperReport jasperReport;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mes", nomeMes);
        map.put("nomefilial", nomeFilial);       

        map.put("nome_advogado", nomeAdvogado);

        Connection con = Conexao.getConexao();

        try {
        
            jasperReport = JasperCompileManager.compileReport("rhlibs/advogadosnomefilial.jrxml");
            JasperPrint print = JasperFillManager.fillReport(jasperReport, map, con);
            JasperViewer.viewReport(print, false);
        
        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void gerarRelatorioNomeMes(String nomeAdvogado, String nomeMes) {
        JasperReport jasperReport;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mes", nomeMes);
       
        map.put("nome_advogado", nomeAdvogado);

        Connection con = Conexao.getConexao();

        try {
            jasperReport = JasperCompileManager.compileReport("rhlibs/relatoriopornome.jrxml");
            JasperPrint print = JasperFillManager.fillReport(jasperReport, map, con);
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, "report exception", ex);
        }
    }

    public void gerarRelatorioAnual(int ano) throws FileNotFoundException, IOException, BackendException {
        
        List<Advogado> advogados = backend.listAll();

        Workbook wb = new HSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("Relatorio");

        int numeroLinha = 0;
        int numeroCel = 0;

        String [] celulas = { "Nome", "Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };
        Row definicaoDeCelulas = sheet.createRow(numeroLinha);
        
        for ( int i = 0; i < celulas.length; i ++ )
        {
            definicaoDeCelulas.createCell(numeroCel++).setCellValue(createHelper.createRichTextString(celulas[i]));
        }
        
        numeroLinha++;
        numeroCel = 0;

        for (Advogado each : advogados) {
            Row linha = sheet.createRow(numeroLinha);
            linha.createCell(numeroCel).setCellValue(createHelper.createRichTextString(each.getNome()));
            
            List<Pagamento> todosPagamentos = each.getHistoricoPagamento();
            List<Pagamento> pagamentosMensais = filtrarPorAno(ano, todosPagamentos);
            
            
            for ( int i = pagamentosMensais.size(); i > 0; i-- )
            {
                Calendar c = Calendar.getInstance(Locale.ENGLISH);
                c.setTime(pagamentosMensais.get(i-1).getDataPagamento());
                int indexMonthExcel = c.get(Calendar.MONTH);
                linha.createCell(indexMonthExcel+1).setCellValue(pagamentosMensais.get(i-1).getValorPago());
       
            }
            
            numeroLinha++;
        }

        FileOutputStream fileOut = new FileOutputStream("C:\\programaRH\\Relatorios\\relatorioanual.xls");
        //FileOutputStream fileOut = new FileOutputStream("rhlibs/relatorioanual.xls");
        wb.write(fileOut);
        fileOut.close();
        
        if ( Desktop.isDesktopSupported() )
        {
            File arquivoRelatorioAnual = new File("C:\\programaRH\\Relatorios\\relatorioanual.xls");
            //File arquivoRelatorioAnual = new File("rhlibs/relatorioanual.xls");
            Desktop.getDesktop().open(arquivoRelatorioAnual);
        }
        
    }

    public List<Pagamento> filtrarPorAno(int ano, List<Pagamento> todosPagamentos) {

        List<Pagamento> anuais = new ArrayList<Pagamento>();

        for (Pagamento each : todosPagamentos) {
            Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
            calendar.setTime(each.getDataPagamento());
            int anoData = calendar.get(Calendar.YEAR);
            if (anoData == ano) {
                anuais.add(each);
            }
        }
        return anuais;
    }
}
