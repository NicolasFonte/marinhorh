package com.rochamarinho.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;

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
    private String nome;
    private double distribuicao;
    @Column(nullable = false, unique = true)
    private String oab;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pagamento> historicoPagamento;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<ValorMes> valores;
    
    private double salarioTotal;
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date associacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nascimento;
    private String uf;
    
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAssociacao() {
        return associacao;
    }

    public void setAssociacao(Date associacao) {
        this.associacao = associacao;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    
    public List<Pagamento> getHistoricoPagamento() {
        return historicoPagamento;
    }

    public void setHistoricoPagamento(List<Pagamento> historicoPagamento) {
        this.historicoPagamento = historicoPagamento;
    }

    public String getOab() {
        return oab;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }

    public double getDistribuicao() {
        return distribuicao;
    }

    public void setDistribuicao(double distribuicao) {
        this.distribuicao = distribuicao;
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

    public void gerarSalarios(double taxa) {
        
        double salarioAnual = (12 * distribuicao) * (1 + (taxa / 100));
        this.salarioTotal = salarioAnual;
        System.out.println("salario anual " + salarioAnual);

        String[] meses = {"janeiro", "fevereiro", "marco", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};

        int monthIndex = 12;
        
        double totalAReceber = salarioAnual;
        double media = 0;
        boolean aumentarOuDiminuir = true;
        
        while ( monthIndex != 0 )
        {
            media = totalAReceber / monthIndex;
            double valorMes = 0;
            double porcentagemParaAddOuSubtrair = Math.random(); //
            
            double decidirSeSomaOuSubtrai = Math.random();
            
            aumentarOuDiminuir = decidirSeSomaOuSubtrai >= 0.5 ? true : false;
            
            if ( aumentarOuDiminuir ) 
            {
                valorMes = media + (media * ( porcentagemParaAddOuSubtrair / 100 )); 
            } else 
            {
                valorMes = media - (media * ( porcentagemParaAddOuSubtrair / 100 )); 
            }
            
            ValorMes valorMesAdvogado = new ValorMes();
            valorMesAdvogado.setMes(meses[monthIndex-1]);
            valorMesAdvogado.setValor(valorMes);
            
            valores.add(valorMesAdvogado);
            
            monthIndex--;
            totalAReceber = totalAReceber - valorMes;
            
            if ( monthIndex == 1 )
            {
                ValorMes ultimoValor = new ValorMes();
                ultimoValor.setMes(meses[monthIndex - 1]);
                ultimoValor.setValor(totalAReceber);  // para garantir que seja o restante que falta para completar o salarioAnual
                valores.add(ultimoValor);
                monthIndex --;                        
            
            }
            
        }
        

    }

    

    public double getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(double salarioTotal) {
        this.salarioTotal = salarioTotal;
    }


    public List<ValorMes> getValores() {
        return valores;
    }

    public void setValores(List<ValorMes> valores) {
        this.valores = valores;
    }


}
