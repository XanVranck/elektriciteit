package be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm;

import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Spanning;
import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Stroom;
import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Weerstand;
import be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm.dto.GroothedenDTO;
import be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm.dto.SpanningDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/wetvanohm")
public class WetVanOhmController {

    @Autowired
    private WetVanOhmService service;

    @RequestMapping(value = "/volt", produces = APPLICATION_JSON_VALUE, method = POST)
    public ResponseEntity<SpanningDTO> berekenVolt(@RequestBody GroothedenDTO grootheden) {
        SpanningDTO spanningDTO = service.berekenVolt(grootheden.getStroomDTO(), grootheden.getWeerstandDTO());

        return new ResponseEntity<>(spanningDTO, OK);
    }

    @RequestMapping("/ampere")
    @GetMapping
    Stroom berekenAmpere(Spanning spanning, Weerstand weerstand) {
        return service.berekenAmpere(spanning, weerstand);
    }

    @RequestMapping("/weerstand")
    @GetMapping
    Weerstand berekenWeerstand(Spanning spanning, Stroom stroom) {
        return service.berekenWeerstand(spanning, stroom);
    }
}
