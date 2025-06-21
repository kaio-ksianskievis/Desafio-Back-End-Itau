package Desafio.Back.End.Itau.demo.Services;



import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Desafio.Back.End.Itau.demo.Dtos.TransacoesRecords;
import Desafio.Back.End.Itau.demo.Models.Statics;
import Desafio.Back.End.Itau.demo.Models.Transacoes;

@Service
public class TransacoesService {
    
    private List<Transacoes> dados = new ArrayList<>();

    public ResponseEntity<Object> criarTransacao(TransacoesRecords transacoesRecords){
        Transacoes model = new Transacoes();
        OffsetDateTime now = OffsetDateTime.now();
        if(transacoesRecords.dataHora().isAfter(now)){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
        BeanUtils.copyProperties(transacoesRecords,model);
        dados.add(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(model);
    }

    public ResponseEntity<Object> deletarTransacoes(){
        dados.clear();
        return ResponseEntity.status(HttpStatus.OK).body("Todas as informações foram apagadas com sucesso");
    }

    public  DoubleSummaryStatistics getStatics(){
        OffsetDateTime now = OffsetDateTime.now();
        DoubleSummaryStatistics statistics =  dados
            .stream()
            .filter((t)-> t.getDataHora().isBefore(now.minusSeconds(60)))
            .collect(Collectors.summarizingDouble(Transacoes::getValor));
            return statistics;
    }
    public ResponseEntity<Statics> mostraStatics(){
        Statics statics = new Statics(getStatics());
        return ResponseEntity.status(HttpStatus.OK).body(statics);
    }
}
