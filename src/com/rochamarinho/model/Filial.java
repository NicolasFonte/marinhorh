package com.rochamarinho.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author nicolas
 */
@Entity
public class Filial implements Comparable<Filial>,Serializable  {
    
    @Id @GeneratedValue
    private Long id;
    @Column(nullable=false, unique=true)
    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    @NotFound(action=NotFoundAction.IGNORE) 
    List<Advogado> advogados;

    public List<Advogado> getAdvogados() {
        if (advogados == null)
        {
            advogados = new ArrayList<Advogado>();
        }
        return advogados;
    }
    
    public void addAdvogado(Advogado adv)
    {
        getAdvogados().add(adv);
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

    @Override
    public int compareTo(Filial o) {
        
        return this.getNome().compareTo(o.getNome());
    }
}
