package com.milliways.OrganizaFilaApi.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milliways.OrganizaFilaApi.model.Pessoa;
import com.milliways.OrganizaFilaApi.repository.PessoaRespository;
@Service
public class FilaService {
    @Autowired
    private PessoaRespository pessoaRespository;

    public List<Pessoa> getFila() {
        List<Pessoa> fila = this.pessoaRespository.findAll();
        Collections.sort(fila);
        return fila;
    }


}
