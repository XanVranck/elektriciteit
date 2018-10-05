package be.xanv.cvo.elektriciteit.elektriciteit.eenheden;

public class Ampere {
    private double ampere;

    private Ampere(double ampere) {
        this.ampere = ampere;
    }

    public static Ampere createAmpereFrom(double ampere) {
        return new Ampere(ampere);
    }
}
