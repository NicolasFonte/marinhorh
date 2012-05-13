package com.rochamarinho.controller;

import com.rochamarinho.backend.impl.MySQLTaxaBackend;
import com.rochamarinho.model.Taxa;
import com.rochamarinho.utils.BackendException;

/**
 *
 * @author nicolas
 */
public class TaxaController {

    MySQLTaxaBackend taxaBackend;
    
    public TaxaController() {
        
    }

    public MySQLTaxaBackend getBackend()
    {
        if (taxaBackend == null)
        {
            taxaBackend = new MySQLTaxaBackend();
        }        
        return taxaBackend;
    }
    
    public void atualizaTaxa(double valor) throws BackendException
    {
        Taxa taxa = new Taxa(valor);
        taxa.setId(1L);
        getBackend().update(taxa);
    }
    
    public Taxa getTaxa() throws BackendException
    {
        return getBackend().read(1L);
    }
    
}
