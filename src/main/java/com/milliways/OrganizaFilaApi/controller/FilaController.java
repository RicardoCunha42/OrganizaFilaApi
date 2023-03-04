package com.milliways.OrganizaFilaApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milliways.OrganizaFilaApi.model.Pessoa;
import com.milliways.OrganizaFilaApi.service.FilaService;

@RestController
@RequestMapping("fila")
public class FilaController {
    @Autowired
    private FilaService filaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> getFila () {
        List<Pessoa> fila = this.filaService.getFila();

        return new ResponseEntity<> (fila, HttpStatus.OK);
    }
}
