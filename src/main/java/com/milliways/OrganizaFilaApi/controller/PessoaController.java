package com.milliways.OrganizaFilaApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milliways.OrganizaFilaApi.dao.PessoaDao;
import com.milliways.OrganizaFilaApi.model.Pessoa;
import com.milliways.OrganizaFilaApi.service.PessoaService;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping()
    public ResponseEntity<List<Pessoa>> getPessoas() {
        List<Pessoa> pessoas = pessoaService.getPessoas();
        return new ResponseEntity<List<Pessoa>>(pessoas, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Pessoa> criaPessoa(@RequestBody PessoaDao pessoaDao) {
        Pessoa pessoa = this.pessoaService.criPessoa(pessoaDao);
        
        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Pessoa> getPessoa (@PathVariable Long id) {
        Pessoa pessoa = this.pessoaService.getPessoa(id);

        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pessoa> alteraPessoa(@PathVariable Long id,
        @RequestBody PessoaDao pessoaDao) {

        Pessoa pessoa = this.pessoaService.alteraPessoa(id, pessoaDao);
        
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @DeleteMapping("{id}") 
    public ResponseEntity<String> deletaPessoa (@PathVariable Long id) {
        this.pessoaService.deletaPessoa(id);

        return new ResponseEntity<>("Pessoa deletada!", HttpStatus.OK);
    }

}
