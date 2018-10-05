package be.xanv.cvo.elektriciteit.elektriciteit.grootheden;

public class Spanning {
    private double volt;

    private Spanning(double volt) {
        this.volt = volt;
    }

    public static Spanning createSpanningFrom(double volt) {
        return new Spanning(volt);
    }

    public double getVolt() {
        return volt;
    }
}
