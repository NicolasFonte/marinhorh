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
    
    private String nome;
    private double salarioBase;
    
    
    public Long getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSalarioBase(double salarioBase)
    {
        this.salarioBase = salarioBase; 
    }
    
    public double getSalarioBase()
    {
        return this.salarioBase;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    
}
