package com.rochamarinho.model;

import com.rochamarinho.utils.Conexao;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int monthIndex = calendar.get(Calendar.MONTH);
        String monthName = "";//escolherCorretoMes(monthIndex);
        JasperReport jasperReport;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mes", monthName);
        
        Connection con = Conexao.getConexao();

        try {
            jasperReport = JasperCompileManager.compileReport("rhlibs/report1.jrxml");
            JasperPrint print = JasperFillManager.fillReport(jasperReport, map, con);
            JasperViewer.viewReport(print, false);
                    
        } catch (JRException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gerarRelatorioAdvogadosMensal(String nomeAdvogado, String nomeFilial,String nomeMes) {
        
        if (nomeAdvogado.equals("") && nomeFilial.equals("Todos"))
        {
            gerarRelatorioGeralMes(nomeMes);
        } else if ( nomeAdvogado.equals("")  )
        {
            gerarRelatorioFilialMes(nomeFilial,nomeMes);
        }
        
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
    
    
    protected static void gerarRelatorioGeralMes(String nomeMes) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    protected static void gerarRelatorioFilialMes(String nomeFilial, String nomeMes) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
