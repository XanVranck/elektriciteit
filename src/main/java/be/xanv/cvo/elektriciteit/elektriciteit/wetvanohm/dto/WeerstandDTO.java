package be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm.dto;

public class WeerstandDTO {
    private double ohm;

    WeerstandDTO(){}

    public WeerstandDTO(double ohm) {
        this.ohm = ohm;
    }

    public double getOhm() {
        return ohm;
    }
}
