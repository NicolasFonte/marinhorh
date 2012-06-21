package com.rochamarinho.controller;

import com.rochamarinho.backend.impl.MySQLAdvogadoBackend;
import com.rochamarinho.backend.impl.MySQLFilialBackend;
import com.rochamarinho.backend.impl.MySQLTaxaBackend;
import com.rochamarinho.model.Advogado;
import com.rochamarinho.model.Filial;
import com.rochamarinho.utils.BackendException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicolas
 */
public class AdvogadoController {

    private MySQLAdvogadoBackend advogadoBackend;
    private MySQLFilialBackend filialBackend;
    private MySQLTaxaBackend taxaBackend;
    static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    
    public AdvogadoController() {
    }

    public boolean cadastrarAdvogado(String oab,String nome,double distribuicao,
                    String filialNome,String associacaoTexto, String nascimentoTexto,String email, String uf, boolean usaTaxa ) throws BackendException, ParseException
    {        
        
        Filial filial = getFilialBackend().buscarPorNome(filialNome);        
                
        Advogado adv = new Advogado();
        adv.setOab(oab);
        adv.setNome(nome);
        adv.setDistribuicao(distribuicao);
        adv.setEmail(email);
        adv.setUf(uf);
        
        Date associacaoData = formatter.parse(associacaoTexto);
        Date nascimentoData = formatter.parse(nascimentoTexto);
        
        adv.setAssociacao(associacaoData);
        adv.setNascimento(nascimentoData);
        
        double taxa = usaTaxa ? taxaBackend.read(1L).getValor() : 0.0;
        
        
        adv.gerarSalarios(taxa);// IMPORTANTE!
        
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

    
    public Advogado byOab(String validOab) throws BackendException
    {
        return getBackend().byOab(validOab);    
    }
    
    public List<Advogado> porNome(String nomeParcial) throws BackendException
    {
        return getBackend().byNome(nomeParcial);
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
    
    public void atualizarAdvogado(String oab, String nome, double distribuicao, double taxa) throws BackendException
    {
        Advogado adv = getBackend().byOab(oab);
        
        adv.setNome(nome);
        adv.setDistribuicao(distribuicao);
        
        
        advogadoBackend.update(adv);
        
    }

    public void deletarAdvogado(String oab) throws BackendException {
        
        Advogado adv = advogadoBackend.byOab(oab);        
        getBackend().remove(adv);
        
    }
}
