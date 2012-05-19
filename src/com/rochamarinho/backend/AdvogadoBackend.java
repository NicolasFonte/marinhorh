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
    Advogado byCpf(String validCpf) throws BackendException;
}
