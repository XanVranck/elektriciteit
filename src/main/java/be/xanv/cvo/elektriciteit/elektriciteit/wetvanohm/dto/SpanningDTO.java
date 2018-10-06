package be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm.dto;

import java.io.Serializable;

public class SpanningDTO implements Serializable{
    private double volt;

    public SpanningDTO(double volt) {
        this.volt = volt;
    }

    public double getVolt() {
        return volt;
    }
}
