package Desafio.Back.End.Itau.demo.Models;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class Transacoes {

    private double valor;
    
    private OffsetDateTime dataHora;    
}
