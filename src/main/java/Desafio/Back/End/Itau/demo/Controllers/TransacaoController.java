package Desafio.Back.End.Itau.demo.Controllers;


import org.springframework.web.bind.annotation.RestController;
import Desafio.Back.End.Itau.demo.Dtos.TransacoesRecords;
import Desafio.Back.End.Itau.demo.Models.Statics;
import Desafio.Back.End.Itau.demo.Models.Transacoes;
import Desafio.Back.End.Itau.demo.Services.TransacoesService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;







@RestController
public class TransacaoController {
    
    @Autowired
    public TransacoesService transacoesService;
    
    @PostMapping("/transacao")
    public ResponseEntity<Transacoes> createTrasacao(@RequestBody @Valid TransacoesRecords body) {
        return transacoesService.criarTransacao(body);
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<Object> deleteTrasacao() {
        return transacoesService.deletarTransacoes();
    }
    
    @GetMapping("/estatistica")
    public ResponseEntity<Statics> mostraStatic() {
        return transacoesService.mostraStatics();
    }
    
}
