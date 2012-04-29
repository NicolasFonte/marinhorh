package com.rochamarinho.backend;

import com.rochamarinho.model.Advogado;
import com.rochamarinho.model.Filial;
import com.rochamarinho.utils.BackendException;
import java.util.List;

/**
 *
 * @author nicolas
 */
public interface FilialBackend extends CRUDBackend<Filial> {
    
    List<Filial> list() throws BackendException;
    List<Advogado> advogadosPorFilial(Filial filial) throws BackendException;
    
}
