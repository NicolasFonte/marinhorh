package com.rochamarinho.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author nicolas
 */

@Entity
public class ValorMes implements Serializable {
    
    
    public ValorMes() {
    }
    
    @Id @GeneratedValue
    private Long id;
    
    private String mes;
    private Double valor;

    
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
