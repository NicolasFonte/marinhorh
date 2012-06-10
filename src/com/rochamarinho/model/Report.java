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

    private static String escolherCorretoMes(int monthIndex) {

        switch (monthIndex) {
            case 0:
                return "janeiro";
            case 1:
                return "fevereiro";
            case 2:
                return "marco";
            case 3:
                return "abril";
            case 4:
                return "maio";
            case 5:
                return "junho";
            case 6:
                return "julho";
            case 7:
                return "agosto";
            case 8:
                return "setembro";
            case 9:
                return "outubro";
            case 10:
                return "novembro";
            case 11:
                return "dezembro";

        }

        throw new IllegalArgumentException("indice do mes deve ser entre 1 e 12");

    }

    public Report() {
    }

    public static void gerarRelatorioTodosAdvogados() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int monthIndex = calendar.get(Calendar.MONTH);
        String monthName = escolherCorretoMes(monthIndex);
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

    public static void gerarRelatorioAdvogadosPorFilial( String nomeFilial) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int monthIndex = calendar.get(Calendar.MONTH);
        String monthName = escolherCorretoMes(monthIndex);
        JasperReport jasperReport;       

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mes", monthName);
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
}
