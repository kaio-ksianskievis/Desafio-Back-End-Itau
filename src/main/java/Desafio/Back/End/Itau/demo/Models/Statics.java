package Desafio.Back.End.Itau.demo.Models;

import java.util.DoubleSummaryStatistics;

import lombok.Data;

@Data
public class Statics {
    
    private Long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public Statics(DoubleSummaryStatistics statistics){
        this.count = statistics.getCount();
        this.sum = statistics.getSum();
        this.avg = statistics.getAverage();
        this.min = statistics.getMin();
        this.max = statistics.getMax();
    }
}
