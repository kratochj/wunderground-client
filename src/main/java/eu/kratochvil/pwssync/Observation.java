package eu.kratochvil.pwssync;

import java.util.Date;

public class Observation {

    String stationID;
    String tz;
    Date obsTimeUtc;
    Date obsTimeLocal;
    long epoch;
    float lat;
    float lon;
    Object solarRadiationHigh;
    Object uvHigh;
    Integer winddirAvg;
    Integer humidityHigh;
    Integer humidityLow;
    Integer humidityAvg;
    Integer qcStatus;

    Metric metric;


}
