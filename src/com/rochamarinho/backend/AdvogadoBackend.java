package com.rochamarinho.backend;

import com.rochamarinho.model.Advogado;
import com.rochamarinho.utils.BackendException;
import java.util.List;

/**
 *
 * @author nicolas
 */
public interface AdvogadoBackend extends CRUDBackend<Advogado> {

    List<Advogado> list() throws BackendException;
    Advogado byOab(String validOab) throws BackendException;
    List<Advogado> byNome(String nomeParcial) throws BackendException;

}
