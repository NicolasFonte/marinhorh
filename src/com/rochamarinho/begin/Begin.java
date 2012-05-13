package com.rochamarinho.begin;

import com.rochamarinho.backend.TaxaBackend;
import com.rochamarinho.backend.impl.MySQLTaxaBackend;
import com.rochamarinho.model.Taxa;
import com.rochamarinho.ui.Principal;
import com.rochamarinho.utils.BackendException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

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
}
