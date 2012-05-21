package com.rochamarinho.model;

import java.io.Serializable;
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

    @Id
    @GeneratedValue
    private Long id;
    private double taxa;
    private String nome;
    private double distribuicao;
    @Column(nullable = false, unique = true)
    private String cpf;
    public transient Map<Integer, Double> mesSalario;

    @OneToMany
    private List<Pagamento> historicoPagamento; 
    
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
        System.out.println("salario anual " + salarioAnual);
        
        double mediaMensal = salarioAnual / 12;
        System.out.println("media mensal " + mediaMensal);
        
        double porcentagemParaVariacaoDoSalario = 0.5;

        mesSalario = new HashMap<Integer, Double>();

        int i = 1;
        while (i < 12) {

            Double valor1 = (mediaMensal + ( (porcentagemParaVariacaoDoSalario * mediaMensal) /100  ));
            Double valor2 = (mediaMensal - ( (porcentagemParaVariacaoDoSalario * mediaMensal) /100  ));
                        
            mesSalario.put(i,valor1);
            i++;        
            mesSalario.put(i, valor2);
            porcentagemParaVariacaoDoSalario++;
            i++;
        
        }

    }
}
