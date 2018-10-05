package be.xanv.cvo.elektriciteit.elektriciteit.grootheden;

public class Weerstand {
    private double ohm;

    private Weerstand(double ohm) {
        this.ohm = ohm;
    }

    public static Weerstand createWeerstandFrom(double ohm) {
        return new Weerstand(ohm);
    }

    public double getOhm() {
        return ohm;
    }
}
