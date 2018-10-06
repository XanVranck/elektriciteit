package be.xanv.cvo.elektriciteit.elektriciteit.berekeningen.wetvanohm;

import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Spanning;
import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Stroom;
import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Weerstand;
import org.springframework.stereotype.Component;

import static be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Spanning.createSpanningFrom;
import static be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Stroom.createStroomFrom;
import static be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Weerstand.createWeerstandFrom;

@Component
public class WetVanOhm {

    Spanning berekenVolt(Stroom stroom, Weerstand weerstand) {
        return createSpanningFrom(stroom.getAmpere() * weerstand.getOhm());
    }

    Stroom berekenAmpere(Spanning spanning, Weerstand weerstand) {
        return createStroomFrom(spanning.getVolt()/weerstand.getOhm());
    }

    Weerstand berekenWeerstand(Spanning spanning, Stroom stroom) {
        return createWeerstandFrom(spanning.getVolt()/stroom.getAmpere());
    }
}
