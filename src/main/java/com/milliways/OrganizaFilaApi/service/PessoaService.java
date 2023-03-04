package com.milliways.OrganizaFilaApi.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milliways.OrganizaFilaApi.dao.PessoaDao;
import com.milliways.OrganizaFilaApi.model.Pessoa;
import com.milliways.OrganizaFilaApi.repository.PessoaRespository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRespository pessoaRespository;
    private Random random = new Random();

    public List<Pessoa> getPessoas () {
        return this.pessoaRespository.findAll();
    }

    public Pessoa criPessoa (PessoaDao pessoaDao) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDao.getNome());
        pessoa.setIdade(pessoaDao.getIdade());
        pessoa.setPosicao(random.ints(0, 1001).findFirst().getAsInt());

        return this.pessoaRespository.save(pessoa);
    }

    public Pessoa getPessoa(Long id) {
        Optional<Pessoa> maybePessoa = this.pessoaRespository.findById(id);
        Pessoa pessoa = maybePessoa.get();
        
        return pessoa;
    }

    public Pessoa alteraPessoa(Long id, PessoaDao pessoaDao) {
        Optional<Pessoa> maybePessoa = this.pessoaRespository.findById(id);
        Pessoa pessoa = maybePessoa.get();

        pessoa.setNome(pessoaDao.getNome());
        pessoa.setIdade(pessoaDao.getIdade());

        return this.pessoaRespository.save(pessoa);
    }

    public void deletaPessoa(Long id) {
        this.pessoaRespository.deleteById(id);;
    }
}
