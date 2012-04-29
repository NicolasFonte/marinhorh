package com.rochamarinho.backend;

import com.rochamarinho.model.Taxa;
import com.rochamarinho.utils.BackendException;

/**
 *
 * @author nicolas
 */
public interface TaxaBackend {

    void create (Taxa t) throws BackendException;
    Taxa update(Taxa t) throws BackendException;
    Taxa read (Long id) throws BackendException;
    
}
