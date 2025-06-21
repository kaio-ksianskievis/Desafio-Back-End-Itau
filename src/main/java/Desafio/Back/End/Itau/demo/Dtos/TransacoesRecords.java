package Desafio.Back.End.Itau.demo.Dtos;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TransacoesRecords(@NotNull @Min(0) double valor, @NotNull OffsetDateTime dataHora) {
    
}
