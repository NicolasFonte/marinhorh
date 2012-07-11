package com.rochamarinho.backend;

import com.rochamarinho.model.Pagamento;
import com.rochamarinho.utils.BackendException;
import java.util.List;

/**
 *
 * @author nicolas
 */
public interface PagamentoBackend extends CRUDBackend<Pagamento> {
    
    List<Pagamento> pagamentosPorAno(String ano) throws BackendException;
    Pagamento ultimoPagamento() throws BackendException;
}
