package be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm.dto;

public class GroothedenDTO {
    private SpanningDTO spanning;
    private StroomDTO stroom;
    private WeerstandDTO weerstand;

    public SpanningDTO getSpanningDTO() {
        return spanning;
    }

    public WeerstandDTO getWeerstandDTO() {
        return weerstand;
    }

    public StroomDTO getStroomDTO() {
        return stroom;
    }

    private void setSpanning(SpanningDTO spanning) {
        this.spanning = spanning;
    }

    private void setStroom(StroomDTO stroom) {
        this.stroom = stroom;
    }

    private void setWeerstand(WeerstandDTO weerstand) {
        this.weerstand = weerstand;
    }
}
