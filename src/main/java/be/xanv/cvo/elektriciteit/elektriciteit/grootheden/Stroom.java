package be.xanv.cvo.elektriciteit.elektriciteit.grootheden;

public class Stroom {
    private double ampere;

    private Stroom(double ampere) {
        this.ampere = ampere;
    }

    public static Stroom createStroomFrom(double ampere) {
        return new Stroom(ampere);
    }

    public double getAmpere() {
        return ampere;
    }
}
