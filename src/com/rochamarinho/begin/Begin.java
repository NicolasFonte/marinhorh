package com.rochamarinho.begin;

import com.rochamarinho.backend.impl.MySQLPagamentoBackend;
import com.rochamarinho.backend.impl.MySQLTaxaBackend;
import com.rochamarinho.model.Pagamento;
import com.rochamarinho.model.Taxa;
import com.rochamarinho.ui.Principal;
import com.rochamarinho.utils.BackendException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class Begin {

    public static void main(String[] args) {
        inicializacao();


        Principal p = new Principal();
        p.setVisible(true);
    }

    private static void inicializacao() {
        MySQLTaxaBackend taxaMysql = new MySQLTaxaBackend();

        try {
            Taxa t = taxaMysql.read(1L);
            if (t == null) {
                taxaMysql.create(new Taxa(10));
            }
        } catch (BackendException ex) {
        }
        avisarCasoExistaPagamentoHouvePagamento();



    }

    public static boolean verificarSeHouvePagamento() throws HeadlessException {
        MySQLPagamentoBackend pagamentoBackend = new MySQLPagamentoBackend();
        try {

            Pagamento pg = pagamentoBackend.ultimoPagamento();

            if (pg == null) {
                return false;
            }

            Date atual = new Date();
            Calendar calendarioAtual = Calendar.getInstance(Locale.ENGLISH);
            calendarioAtual.setTime(atual);

            Calendar calendarioUltimoPagamento = Calendar.getInstance(Locale.ENGLISH);
            calendarioUltimoPagamento.setTime(atual);

            int mesAtual = calendarioAtual.get(Calendar.MONTH);
            int ultimoPagamento = calendarioUltimoPagamento.get(Calendar.MONTH);

            if (mesAtual != ultimoPagamento) {
                return false;
            }

        } catch (BackendException ex) {
            Logger.getLogger(Begin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static String getFirstTaxa() {
        File file = new File("conf.properties");
        Properties props = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            //lê os dados que estão no arquivo  
            props.load(fis);
            fis.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        return props.getProperty("taxa");

    }

    public static void avisarCasoExistaPagamentoHouvePagamento() {
        MySQLPagamentoBackend pagamentoBackend = new MySQLPagamentoBackend();
        try {


            Pagamento pg = pagamentoBackend.ultimoPagamento();

            if (pg == null) {
                JOptionPane.showMessageDialog(null, "Atenção, ainda não foi feito nenhum pagamento no sistema");
            }

            Date atual = new Date();
            Calendar calendarioAtual = Calendar.getInstance(Locale.ENGLISH);
            calendarioAtual.setTime(atual);

            Calendar calendarioUltimoPagamento = Calendar.getInstance(Locale.ENGLISH);
            calendarioUltimoPagamento.setTime(atual);

            int mesAtual = calendarioAtual.get(Calendar.MONTH);
            int ultimoPagamento = calendarioUltimoPagamento.get(Calendar.MONTH);

            if (mesAtual != ultimoPagamento) {
                JOptionPane.showMessageDialog(null, "A confirmacao pagamento desse mes nao foi efetuada");
                
            }

        } catch (BackendException ex) {
            Logger.getLogger(Begin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
