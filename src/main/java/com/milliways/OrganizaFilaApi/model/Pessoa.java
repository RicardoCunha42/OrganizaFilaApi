package com.milliways.OrganizaFilaApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pessoa implements Comparable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private int posicao;
    
    @Override
    public int compareTo(Object objeto) {
        Pessoa pessoa = (Pessoa) objeto;
        return this.posicao - pessoa.getPosicao();
    }
}
