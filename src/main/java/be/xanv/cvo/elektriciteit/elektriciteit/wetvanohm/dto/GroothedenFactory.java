package be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm.dto;

import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Spanning;
import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Stroom;
import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Weerstand;
import org.springframework.stereotype.Component;

@Component
public class GroothedenFactory {

    public SpanningDTO createSpanningDTO(Spanning spanning) {
        return new SpanningDTO(spanning.getVolt());
    }

    public StroomDTO createStroomDTO(Stroom stroom) {
        return new StroomDTO(stroom.getAmpere());
    }

    public WeerstandDTO createWeerstandDTO(Weerstand weerstand) {
        return new WeerstandDTO(weerstand.getOhm());
    }
}
