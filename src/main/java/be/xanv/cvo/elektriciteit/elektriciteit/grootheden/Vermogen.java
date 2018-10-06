package be.xanv.cvo.elektriciteit.elektriciteit.grootheden;

public class Vermogen {
    private double watt;

    private Vermogen(double watt) {
        this.watt = watt;
    }

    public static Vermogen createVermogenFrom(double watt) {
        return new Vermogen(watt);
    }

    public double getWatt() {
        return watt;
    }
}
