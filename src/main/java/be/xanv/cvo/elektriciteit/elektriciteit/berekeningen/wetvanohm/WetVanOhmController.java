package be.xanv.cvo.elektriciteit.elektriciteit.berekeningen.wetvanohm;

import be.xanv.cvo.elektriciteit.elektriciteit.berekeningen.dto.GroothedenDTO;
import be.xanv.cvo.elektriciteit.elektriciteit.berekeningen.dto.SpanningDTO;
import be.xanv.cvo.elektriciteit.elektriciteit.berekeningen.dto.StroomDTO;
import be.xanv.cvo.elektriciteit.elektriciteit.berekeningen.dto.WeerstandDTO;
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
    public ResponseEntity<StroomDTO> berekenAmpere(@RequestBody GroothedenDTO grootheden) {
        StroomDTO stroomDTO = service.berekenAmpere(grootheden.getSpanningDTO(), grootheden.getWeerstandDTO());
        return new ResponseEntity<>(stroomDTO, OK);
    }

    @RequestMapping("/ohm")
    @GetMapping
    ResponseEntity<WeerstandDTO> berekenOhm(@RequestBody GroothedenDTO grootheden) {
        WeerstandDTO weerstandDTO = service.berekenWeerstand(grootheden.getSpanningDTO(), grootheden.getStroomDTO());
        return new ResponseEntity<>(weerstandDTO, OK);
    }
}
