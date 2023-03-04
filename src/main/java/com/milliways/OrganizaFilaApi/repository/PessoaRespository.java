package com.milliways.OrganizaFilaApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milliways.OrganizaFilaApi.model.Pessoa;

public interface PessoaRespository extends JpaRepository<Pessoa, Long> {
    
}
