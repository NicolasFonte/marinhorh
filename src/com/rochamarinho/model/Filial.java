package com.rochamarinho.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author nicolas
 */
@Entity
public class Filial implements Serializable {
    
    @Id @GeneratedValue
    private Long id;
    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    List<Advogado> advogados;

    public List<Advogado> getAdvogados() {
        if (advogados == null)
        {
            advogados = new ArrayList<Advogado>();
        }
        return advogados;
    }

    public void setAdvogados(List<Advogado> advogados) {
        this.advogados = advogados;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
