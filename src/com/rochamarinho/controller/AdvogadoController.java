package com.rochamarinho.controller;

import com.rochamarinho.backend.impl.MySQLAdvogadoBackend;
import com.rochamarinho.backend.impl.MySQLFilialBackend;
import com.rochamarinho.model.Advogado;
import com.rochamarinho.model.Filial;
import com.rochamarinho.utils.BackendException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author nicolas
 */
public class AdvogadoController {

    private MySQLAdvogadoBackend advogadoBackend;
    private MySQLFilialBackend filialBackend;
    static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    
    public AdvogadoController() {
    }

    public boolean cadastrarAdvogado(String oab,String nome,double distribuicao,
                    double valorTaxa,String filialNome,String associacaoTexto, String nascimentoTexto,String email ) throws BackendException
    {        
        
        Filial filial = getFilialBackend().buscarPorNome(filialNome);        
                
        Advogado adv = new Advogado();
        adv.setOab(oab);
        adv.setTaxa(valorTaxa);
        adv.setNome(nome);
        adv.setDistribuicao(distribuicao);
        adv.setEmail(email);

        //datas!
        //formatter
        
        
        
        
        filial.addAdvogado(adv);
        
        getFilialBackend().update(filial);
        
        return true;
        
    }
    
    public List<Advogado> listarAdvogados()
    {
        return getBackend().list();
    }
            
    public MySQLAdvogadoBackend getBackend() {
        if (advogadoBackend == null)
        {
            advogadoBackend = new MySQLAdvogadoBackend();
        }        
        return advogadoBackend;
    }

    public void setBackend(MySQLAdvogadoBackend backend) {
        this.advogadoBackend = backend;
    }

    public Advogado byCpf(String cpf) throws BackendException {        
        return getBackend().byCpf(cpf);
        
    }
    
    public MySQLFilialBackend getFilialBackend() {
        if (filialBackend == null)
        {
            filialBackend = new MySQLFilialBackend();
        }        
        return filialBackend;
    }

    public void setFilialBackend(MySQLFilialBackend filialBackend) {
        this.filialBackend = filialBackend;
    }
    
    public void atualizarAdvogado(String cpf, String nome, double distribuicao, double taxa) throws BackendException
    {
        Advogado adv = getBackend().byCpf(cpf);
        
        adv.setNome(nome);
        adv.setDistribuicao(distribuicao);
        adv.setTaxa(taxa);
        
        advogadoBackend.update(adv);
        
    }

    public void deletarAdvogado(String cpf) throws BackendException {
        
        Advogado adv = advogadoBackend.byCpf(cpf);        
        getBackend().remove(adv);
        
    }
}
