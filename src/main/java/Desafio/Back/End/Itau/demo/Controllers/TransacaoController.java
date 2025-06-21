package Desafio.Back.End.Itau.demo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Desafio.Back.End.Itau.demo.Dtos.TransacoesRecords;
import Desafio.Back.End.Itau.demo.Models.Transacoes;
import Desafio.Back.End.Itau.demo.Services.TransacoesService;
import jakarta.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;



@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    
    @Autowired
    public TransacoesService transacoesService;
    
    @PostMapping
    public ResponseEntity<Transacoes> createTrasacao(@RequestBody @Valid TransacoesRecords body) {
        return transacoesService.criarTransacao(body);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteTrasacao() {
        return transacoesService.deletarTransacoes();
    }
    
}
