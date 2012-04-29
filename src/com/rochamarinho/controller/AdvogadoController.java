package com.rochamarinho.controller;

import com.rochamarinho.backend.impl.MySQLAdvogadoBackend;
import com.rochamarinho.model.Advogado;
import com.rochamarinho.utils.BackendException;
import java.util.List;

/**
 *
 * @author nicolas
 */
public class AdvogadoController {

    private MySQLAdvogadoBackend backend;

    public AdvogadoController() {
    }

    public void cadastrarAdvogado(String nome,double salarioBase) throws BackendException
    {
        
        Advogado adv = new Advogado();
        adv.setNome(nome);
        adv.setSalarioBase(salarioBase);
        getBackend().create(adv);
    }
    
    public List<Advogado> listarAdvogados()
    {
        return getBackend().list();
    }
    
            
            
    public MySQLAdvogadoBackend getBackend() {
        if (backend == null)
        {
            backend = new MySQLAdvogadoBackend();
        }
        
        return backend;
    }

    public void setBackend(MySQLAdvogadoBackend backend) {
        this.backend = backend;
    }
}
