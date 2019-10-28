package eu.kratochvil.pwssync;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObservationFactory {

    private static final Logger log = LogManager.getLogger(ObservationFactory.class);

    public static ObservationElastic convert(Observation o) {
        return new ObservationElastic(o.getStationID(), o.getTz(),
                ObservationFactory.convertPwsDate(o.getObsTimeUtc()),
                ObservationFactory.convertPwsDate(o.getObsTimeLocal()),
                o.getEpoch(), o.getLat(), o.getLon(), o.getSolarRadiationHigh(), o.getUvHigh(),
                o.getWinddirAvg(), o.getHumidityHigh(), o.getHumidityLow(), o.getHumidityAvg(), o.getQcStatus(),
                ObservationFactory.converMetric(o.getMetric()));
    }

    private static MetricElastic converMetric(Metric m) {
        return new MetricElastic(m.getTempHigh(), m.getTempLow(), m.getTempAvg(), m.getWindspeedHigh(),
                m.getWindspeedLow(), m.getWindspeedAvg(), m.getWindgustHigh(), m.getWindgustLow(),
                m.getWindgustAvg(), m.getDewptHigh(), m.getDewptLow(), m.getDewptAvg(), m.getWindchillHigh(),
                m.getWindchillLow(), m.getWindchillAvg(), m.getHeatindexHigh(), m.getHeatindexLow(),
                m.getHeatindexAvg(), m.getPressureMax(), m.getPressureMin(), m.getPressureTrend(),
                m.getPrecipRate(), m.getPrecipTotal());
    }

    private static DateFormat dateFormatResult = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private static DateFormat dateFormatSource = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static Date convertPwsDate(String in) {
        try {
            return dateFormatSource.parse(in);
        } catch (ParseException e) {
            try {
                return dateFormatResult.parse(in);
            } catch (ParseException ex) {
                log.error("Error parsing data", ex);
                return null;
            }
        }
    }
}
