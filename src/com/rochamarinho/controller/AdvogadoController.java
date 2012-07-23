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

    public boolean cadastrarAdvogado(String oab, String nome, double distribuicao,
            String filialNome, String associacaoTexto, String nascimentoTexto, String email, String uf, boolean usaTaxa) throws BackendException, ParseException {

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

        double taxa = usaTaxa ? getTaxaBackend().read(1L).getValor() : 0.0;

        adv.gerarSalarios(taxa);// IMPORTANTE!

        filial.addAdvogado(adv);
        getFilialBackend().update(filial);
        return true;

    }

    public List<Advogado> listarAdvogados() throws BackendException {
        return getBackend().list();
    }

    public MySQLAdvogadoBackend getBackend() {
        if (advogadoBackend == null) {
            advogadoBackend = new MySQLAdvogadoBackend();
        }
        return advogadoBackend;
    }

    public MySQLTaxaBackend getTaxaBackend() {
        if (taxaBackend == null) {
            taxaBackend = new MySQLTaxaBackend();
        }
        return taxaBackend;

    }

    public void setBackend(MySQLAdvogadoBackend backend) {
        this.advogadoBackend = backend;
    }

    public Advogado byOab(String validOab) throws BackendException {
        return getBackend().byOab(validOab);
    }

    public List<Advogado> porNome(String nomeParcial) throws BackendException {
        return getBackend().byNome(nomeParcial);
    }

    public MySQLFilialBackend getFilialBackend() {
        if (filialBackend == null) {
            filialBackend = new MySQLFilialBackend();
        }
        return filialBackend;
    }

    public void setFilialBackend(MySQLFilialBackend filialBackend) {
        this.filialBackend = filialBackend;
    }

    public boolean atualizarAdvogado(String oab, String nome, double distribuicao,
            String filialNome, String associacaoTexto, String nascimentoTexto, String email, String uf, boolean usaTaxa) throws BackendException, ParseException {

        Advogado adv = getBackend().byOab(oab);
        double distribuicaoAntiga = adv.getDistribuicao();

        adv.setOab(oab);
        adv.setNome(nome);
        adv.setDistribuicao(distribuicao);
        adv.setEmail(email);
        adv.setUf(uf);

        Date associacaoData = formatter.parse(associacaoTexto);
        Date nascimentoData = formatter.parse(nascimentoTexto);

        adv.setAssociacao(associacaoData);
        adv.setNascimento(nascimentoData);

        double taxa = usaTaxa ? getTaxaBackend().read(1L).getValor() : 0.0;

        if ( Math.abs(distribuicaoAntiga - distribuicao) > 1.0)
        {
            adv.gerarSalarios(taxa);
        }
        
        getBackend().update(adv);
        
        
        return true;

    }

    public void deletarAdvogado(String oab) throws BackendException {

        Advogado adv = advogadoBackend.byOab(oab);
        getBackend().remove(adv);

    }
}
