package be.xanv.cvo.elektriciteit.elektriciteit.berekeningen.wetvanohm.dto;

public class StroomDTO {
    private double ampere;

    StroomDTO(){}

    public StroomDTO(double ampere) {
        this.ampere = ampere;
    }

    public double getAmpere() {
        return ampere;
    }
}