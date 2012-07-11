package com.rochamarinho.model;

import com.rochamarinho.backend.impl.MySQLAdvogadoBackend;
import com.rochamarinho.utils.Conexao;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
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


/**
 *
 * @author nicolas
 */
public class Report {

    public Report() {
    }

    public static void gerarRelatorioTodosAdvogados() {
    }

    public static void gerarRelatorioAdvogadosMensal(String nomeAdvogado, String nomeFilial, String nomeMes) {



        if (nomeAdvogado.equals("") && nomeFilial.equals("Todos")) // sem nome e sem filial
        {
            gerarRelatorioGeralMes(nomeMes);
        } else if (nomeAdvogado.equals("") && !nomeFilial.equals("Todos")) //sem nome e com filial
        {
            gerarRelatorioFilialMes(nomeFilial, nomeMes);
        } else if (!nomeAdvogado.equals("") && !nomeFilial.equals("Todos")) //com nome e com filial
        {
            gerarRelatorioNomeEFilialMes(nomeAdvogado, nomeFilial, nomeMes);

        } else // creio que a unica chance seja com nome e sem filial
        {
            JOptionPane.showMessageDialog(null, "Ainda não suportado");
            gerarRelatorioNomeMes(nomeAdvogado, nomeMes);
        }



    }

    protected static void gerarRelatorioGeralMes(String nomeMes) {

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

    protected static void gerarRelatorioFilialMes(String nomeFilial, String nomeMes) {
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

    protected static void gerarRelatorioNomeEFilialMes(String nomeAdvogado, String nomeFilial, String nomeMes) {
        JasperReport jasperReport;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mes", nomeMes);
        map.put("nomefilial", nomeFilial);

        nomeAdvogado = "%" + nomeAdvogado + "%"; // para pegar parte do nome.

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

    protected static void gerarRelatorioNomeMes(String nomeAdvogado, String nomeMes) {
        JasperReport jasperReport;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mes", nomeMes);

        nomeAdvogado = "%" + nomeAdvogado + "%"; // para pegar parte do nome.
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

    protected static void gerarRelatorioAnual(int ano) throws FileNotFoundException, IOException
    {
        MySQLAdvogadoBackend backend = new MySQLAdvogadoBackend();
        List <Advogado> advogados = backend.list();
        
        
        Workbook wb = new HSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("Relatorio");
        
        int numeroLinha = 0;
        int numeroCel = 0;
        
        Row definicaoDeCelulas =  sheet.createRow(numeroLinha);
        definicaoDeCelulas.createCell(numeroCel).setCellValue(createHelper.createRichTextString("Nome"));
        definicaoDeCelulas.createCell(++numeroCel).setCellValue(createHelper.createRichTextString("Janeiro"));
        definicaoDeCelulas.createCell(++numeroCel).setCellValue(createHelper.createRichTextString("Fevereiro"));
        definicaoDeCelulas.createCell(++numeroCel).setCellValue(createHelper.createRichTextString("Marco"));
        definicaoDeCelulas.createCell(++numeroCel).setCellValue(createHelper.createRichTextString("Abril"));
        definicaoDeCelulas.createCell(++numeroCel).setCellValue(createHelper.createRichTextString("Maio"));
        definicaoDeCelulas.createCell(++numeroCel).setCellValue(createHelper.createRichTextString("Junho"));
        definicaoDeCelulas.createCell(++numeroCel).setCellValue(createHelper.createRichTextString("Julho"));
        definicaoDeCelulas.createCell(++numeroCel).setCellValue(createHelper.createRichTextString("Agosto"));
        definicaoDeCelulas.createCell(++numeroCel).setCellValue(createHelper.createRichTextString("Setembro"));
        definicaoDeCelulas.createCell(++numeroCel).setCellValue(createHelper.createRichTextString("Outubro"));
        definicaoDeCelulas.createCell(++numeroCel).setCellValue(createHelper.createRichTextString("Novembro"));        
        definicaoDeCelulas.createCell(++numeroCel).setCellValue(createHelper.createRichTextString("Dezembro"));        
        
        numeroLinha++;
        numeroCel = 0;
        
        for (Advogado each : advogados)
        {
            Row linha =  sheet.createRow(numeroLinha);
            linha.createCell(numeroCel).setCellValue(createHelper.createRichTextString(each.getNome()));
            
            numeroLinha++;
        }
        
        
        FileOutputStream fileOut = new FileOutputStream("rhlibs/relatorioanual.xls");
        wb.write(fileOut);
        fileOut.close();
        
    
    }

}
