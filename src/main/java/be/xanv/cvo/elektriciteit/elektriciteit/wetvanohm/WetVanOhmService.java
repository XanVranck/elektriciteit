package be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm;

import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Spanning;
import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Stroom;
import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Weerstand;
import be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm.dto.GroothedenFactory;
import be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm.dto.SpanningDTO;
import be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm.dto.StroomDTO;
import be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm.dto.WeerstandDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    Stroom berekenAmpere(Spanning spanning, Weerstand weerstand) {
        return wetVanOhm.berekenAmpere(spanning, weerstand);
    }

    Weerstand berekenWeerstand(Spanning spanning, Stroom stroom) {
        return wetVanOhm.berekenWeerstand(spanning, stroom);
    }
}
