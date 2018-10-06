package be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm.dto;

import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Spanning;
import org.springframework.stereotype.Component;

@Component
public class GroothedenFactory {

    public SpanningDTO createSpanningDTO(Spanning spanning) {
        return new SpanningDTO(spanning.getVolt());
    }

}
