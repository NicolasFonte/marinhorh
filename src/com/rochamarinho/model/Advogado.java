package com.rochamarinho.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    
    @OneToOne(cascade = CascadeType.ALL)
    private Taxa taxa;    
    
    private String pin;
    private String nome;    
    private double distribuicao;

    public double getDistribuicao() {
        return distribuicao;
    }

    public void setDistribuicao(double distribuicao) {
        this.distribuicao = distribuicao;
    }

    public Taxa getTaxa() {
        return taxa;
    }

    public void setTaxa(Taxa taxa) {
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

        public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    
}
