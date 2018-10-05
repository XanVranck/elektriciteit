package be.xanv.cvo.elektriciteit.elektriciteit.eenheden;

public class Volt {
    private double volt;

    private Volt(double volt) {
        this.volt = volt;
    }

    public static Volt createVoltFrom(double volt) {
        return new Volt(volt);
    }

    public double getVolt() {
        return volt;
    }
}
