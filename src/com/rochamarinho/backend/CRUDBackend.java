package com.rochamarinho.backend;

import com.rochamarinho.utils.BackendException;

/**
 *
 * @author nicolas
 */
public interface CRUDBackend < T extends Object > {
    
    T update(T object) throws BackendException;
    void create(T object) throws BackendException;
    void remove(T object) throws BackendException;
    T read(Long id) throws BackendException;        
    
}
