package Desafio.Back.End.Itau.demo.Services;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Desafio.Back.End.Itau.demo.Dtos.TransacoesRecords;
import Desafio.Back.End.Itau.demo.Models.Transacoes;

@Service
public class TransacoesService {
    
    private List<Transacoes> dados = new ArrayList<>();

    public ResponseEntity<Transacoes> criarTransacao(TransacoesRecords transacoesRecords){
        Transacoes model = new Transacoes();
        BeanUtils.copyProperties(transacoesRecords,model);
        dados.add(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(model);
    }

    public ResponseEntity<Object> deletarTransacoes(){
        dados.clear();
        return ResponseEntity.status(HttpStatus.OK).body("Todas as informações foram apagadas com sucesso");
    }

}
