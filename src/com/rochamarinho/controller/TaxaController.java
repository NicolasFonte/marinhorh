package com.rochamarinho.controller;

import com.rochamarinho.backend.impl.MySQLTaxaBackend;
import com.rochamarinho.model.Taxa;
import com.rochamarinho.utils.BackendException;

/**
 *
 * @author nicolas
 */
public class TaxaController {
    
    private MySQLTaxaBackend backend;
    
    public TaxaController() {
    }
    
    public MySQLTaxaBackend getBackend() {
        return backend;
    }

    public void setBackend(MySQLTaxaBackend backend) {
        this.backend = backend;
    }

    
    public void cadastrarTaxa(double valor) throws BackendException
    {
        Taxa taxa = new Taxa();
        taxa.setValor(valor);        
        getBackend().create(taxa);
    }
    
}
