package be.xanv.cvo.elektriciteit.elektriciteit.berekeningen.wetvanohm;

import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Spanning;
import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Stroom;
import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Weerstand;
import be.xanv.cvo.elektriciteit.elektriciteit.berekeningen.dto.GroothedenFactory;
import be.xanv.cvo.elektriciteit.elektriciteit.berekeningen.dto.SpanningDTO;
import be.xanv.cvo.elektriciteit.elektriciteit.berekeningen.dto.StroomDTO;
import be.xanv.cvo.elektriciteit.elektriciteit.berekeningen.dto.WeerstandDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Spanning.createSpanningFrom;
import static be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Stroom.createStroomFrom;
import static be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Weerstand.createWeerstandFrom;

@Service
public class WetVanOhmService {

    @Autowired
    private WetVanOhm wetVanOhm;

    @Autowired
    private GroothedenFactory groothedenFactory;

    SpanningDTO berekenVolt(StroomDTO stroom, WeerstandDTO weerstand) {
        Spanning spanning = wetVanOhm.berekenVolt(createStroomFrom(stroom.getAmpere()), createWeerstandFrom(weerstand.getOhm()));
        return groothedenFactory.createSpanningDTO(spanning);
    }

    StroomDTO berekenAmpere(SpanningDTO spanning, WeerstandDTO weerstand) {
        Stroom stroom = wetVanOhm.berekenAmpere(createSpanningFrom(spanning.getVolt()), createWeerstandFrom(weerstand.getOhm()));
        return groothedenFactory.createStroomDTO(stroom);
    }

    WeerstandDTO berekenWeerstand(SpanningDTO spanning, StroomDTO stroom) {
        Weerstand weerstand = wetVanOhm.berekenWeerstand(createSpanningFrom(spanning.getVolt()), createStroomFrom(stroom.getAmpere()));
        return groothedenFactory.createWeerstandDTO(weerstand);
    }
}
