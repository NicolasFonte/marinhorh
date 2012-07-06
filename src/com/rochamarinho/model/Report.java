package com.rochamarinho.model;

import com.rochamarinho.utils.Conexao;
import java.sql.Connection;
import java.util.HashMap;
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

    private static void gerarRelatorioNomeMes(String nomeAdvogado, String nomeMes) {
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
}
