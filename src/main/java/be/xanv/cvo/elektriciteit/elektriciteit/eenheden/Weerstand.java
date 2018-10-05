package be.xanv.cvo.elektriciteit.elektriciteit.eenheden;

public class Weerstand {
    private double weerstand;

    private Weerstand(double weerstand) {
        this.weerstand = weerstand;
    }

    public static Weerstand createWeerstandFrom(double weerstand) {
        return new Weerstand(weerstand);
    }
}
