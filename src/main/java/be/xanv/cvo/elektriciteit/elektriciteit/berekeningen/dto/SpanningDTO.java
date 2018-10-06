package be.xanv.cvo.elektriciteit.elektriciteit.berekeningen.dto;

import java.io.Serializable;

public class SpanningDTO implements Serializable{
    private double volt;

    SpanningDTO(){}

    public SpanningDTO(double volt) {
        this.volt = volt;
    }

    public double getVolt() {
        return volt;
    }
}
