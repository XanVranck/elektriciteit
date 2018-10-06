package be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm;

import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Spanning;
import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Stroom;
import be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Weerstand;
import org.junit.Before;
import org.junit.Test;

import static be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Spanning.createSpanningFrom;
import static be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Stroom.createStroomFrom;
import static be.xanv.cvo.elektriciteit.elektriciteit.grootheden.Weerstand.createWeerstandFrom;
import static org.assertj.core.api.Assertions.assertThat;

public class WetVanOhmTest {

    private WetVanOhm wetVanOhm;

    @Before
    public void setUp() throws Exception {
        wetVanOhm = new WetVanOhm();
    }

    @Test
    public void berekenVolt_happyPath() throws Exception {
        Spanning result = wetVanOhm.berekenVolt(createStroomFrom(2), createWeerstandFrom(5));

        assertThat(result.getVolt()).isEqualTo(10);
    }

    @Test
    public void berekenVolt_happyPathMetDoubles() throws Exception {
        Spanning result = wetVanOhm.berekenVolt(createStroomFrom(2.5), createWeerstandFrom(2.8964));

        assertThat(result.getVolt()).isEqualTo(7.241);
    }

    @Test
    public void berekenAmpere_happyPath() throws Exception {
        Stroom result = wetVanOhm.berekenAmpere(createSpanningFrom(10), createWeerstandFrom(5));

        assertThat(result.getAmpere()).isEqualTo(2);
    }

    @Test
    public void berekenAmpere_happyPathMetDoubles() throws Exception {
        Stroom result = wetVanOhm.berekenAmpere(createSpanningFrom(12.5), createWeerstandFrom(3.356));

        assertThat(result.getAmpere()).isEqualTo(3.724672228843862);
    }

    @Test
    public void berekenWeerstand_happyPath() throws Exception {
        Weerstand result = wetVanOhm.berekenWeerstand(createSpanningFrom(15), createStroomFrom(5));

        assertThat(result.getOhm()).isEqualTo(3);
    }

    @Test
    public void berekenWeerstand_happyPathMetDoubles() throws Exception {
        Weerstand result = wetVanOhm.berekenWeerstand(createSpanningFrom(12.5), createStroomFrom(4.3856));

        assertThat(result.getOhm()).isEqualTo(2.8502371397300252);
    }
}