package com.rochamarinho.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author nicolas
 */
@Entity
public class Advogado implements Serializable {

    public Advogado() {
    
        valores = new ArrayList<ValorMes>();
    }

    @Id
    @GeneratedValue
    private Long id;
    private double taxa;
    private String nome;
    private double distribuicao;
    @Column(nullable = false, unique = true)
    private String cpf;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pagamento> historicoPagamento;    
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<ValorMes> valores;
    
    private double salarioTotal;
    
    private transient double [] listaDePorcentagensAleatorias = {0.4,0.425,0.45,0.475,0.5,0.525,0.55,0.575,0.6,0.625,0.650,0.675,0.7 };
    
    public List<Pagamento> getHistoricoPagamento() {
        return historicoPagamento;
    }

    public void setHistoricoPagamento(List<Pagamento> historicoPagamento) {
        this.historicoPagamento = historicoPagamento;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getDistribuicao() {
        return distribuicao;
    }

    public void setDistribuicao(double distribuicao) {
        this.distribuicao = distribuicao;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void gerarSalarios() {
        double salarioAnual = (12 * distribuicao) * (1 + (taxa / 100));
        this.salarioTotal = salarioAnual;
        System.out.println("salario anual " + salarioAnual);
        
        double mediaMensal = salarioAnual / 12;
        System.out.println("media mensal " + mediaMensal);
        double porcentagemParaVariacaoDoSalario = escolherUmaPorcentagemAleatoria();

        String [] meses = {"janeiro","fevereiro","marco","abril","maio","junho","julho","agosto","setembro","outubro","novembro","dezembro"};
        int i = 1;
        ValorMes umValor;
            
        while (i < 12) {

            Double valor1 = (mediaMensal + ( (porcentagemParaVariacaoDoSalario * mediaMensal) /100  ));
            Double valor2 = (mediaMensal - ( (porcentagemParaVariacaoDoSalario * mediaMensal) /100  ));
            
            umValor = new ValorMes();
            
            umValor.setValor(valor1);
            umValor.setMes(meses[i-1]);         
            valores.add(umValor);
            
            i++;
            
            umValor = new ValorMes();
            
            umValor.setValor(valor2);
            umValor.setMes(meses[i-1]);
            valores.add(umValor);
            
            porcentagemParaVariacaoDoSalario++;
            i++;
        
        }

    }

    public double getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(double salarioTotal) {
        this.salarioTotal = salarioTotal;
    }

    protected double escolherUmaPorcentagemAleatoria() {
        int numero = (int) Math.round( 13 * Math.random());
        System.out.println("numero aleatorio 1-13 : " + numero);
        if ( numero < 0 ) numero = 0;
        
        return listaDePorcentagensAleatorias[numero-1];
    }
    
    public List<ValorMes> getValores() {
        return valores;
    }

    public void setValores(List<ValorMes> valores) {
        this.valores = valores;
    }
}
