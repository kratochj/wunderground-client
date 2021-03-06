package eu.kratochvil.pwssync.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Date;

public class ObservationElastic {

    private String id;
    private String stationID;
    private String tz;
    private Date obsTimeUtc;
    private Date obsTimeLocal;
    private long epoch;
    private float lat;
    private float lon;
    private Object solarRadiationHigh;
    private Object uvHigh;
    private Integer winddirAvg;
    private Integer humidityHigh;
    private Integer humidityLow;
    private Integer humidityAvg;
    private Integer qcStatus;

    private MetricElastic metric;

    public ObservationElastic() {
    }

    public ObservationElastic(String stationID, String tz, Date obsTimeUtc, Date obsTimeLocal, long epoch, float lat, float lon, Object solarRadiationHigh, Object uvHigh, Integer winddirAvg, Integer humidityHigh, Integer humidityLow, Integer humidityAvg, Integer qcStatus, MetricElastic metric) {
        this.stationID = stationID;
        this.tz = tz;
        this.obsTimeUtc = obsTimeUtc;
        this.obsTimeLocal = obsTimeLocal;
        this.epoch = epoch;
        this.lat = lat;
        this.lon = lon;
        this.solarRadiationHigh = solarRadiationHigh;
        this.uvHigh = uvHigh;
        this.winddirAvg = winddirAvg;
        this.humidityHigh = humidityHigh;
        this.humidityLow = humidityLow;
        this.humidityAvg = humidityAvg;
        this.qcStatus = qcStatus;
        this.metric = metric;
        this.id = stationID + epoch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public Date getObsTimeUtc() {
        return obsTimeUtc;
    }

    public void setObsTimeUtc(Date obsTimeUtc) {
        this.obsTimeUtc = obsTimeUtc;
    }

    public Date getObsTimeLocal() {
        return obsTimeLocal;
    }

    public void setObsTimeLocal(Date obsTimeLocal) {
        this.obsTimeLocal = obsTimeLocal;
    }

    public long getEpoch() {
        return epoch;
    }

    public void setEpoch(long epoch) {
        this.epoch = epoch;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public Object getSolarRadiationHigh() {
        return solarRadiationHigh;
    }

    public void setSolarRadiationHigh(Object solarRadiationHigh) {
        this.solarRadiationHigh = solarRadiationHigh;
    }

    public Object getUvHigh() {
        return uvHigh;
    }

    public void setUvHigh(Object uvHigh) {
        this.uvHigh = uvHigh;
    }

    public Integer getWinddirAvg() {
        return winddirAvg;
    }

    public void setWinddirAvg(Integer winddirAvg) {
        this.winddirAvg = winddirAvg;
    }

    public Integer getHumidityHigh() {
        return humidityHigh;
    }

    public void setHumidityHigh(Integer humidityHigh) {
        this.humidityHigh = humidityHigh;
    }

    public Integer getHumidityLow() {
        return humidityLow;
    }

    public void setHumidityLow(Integer humidityLow) {
        this.humidityLow = humidityLow;
    }

    public Integer getHumidityAvg() {
        return humidityAvg;
    }

    public void setHumidityAvg(Integer humidityAvg) {
        this.humidityAvg = humidityAvg;
    }

    public Integer getQcStatus() {
        return qcStatus;
    }

    public void setQcStatus(Integer qcStatus) {
        this.qcStatus = qcStatus;
    }

    public MetricElastic getMetric() {
        return metric;
    }

    public void setMetric(MetricElastic metric) {
        this.metric = metric;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("stationID", stationID)
                .append("tz", tz)
                .append("obsTimeUtc", obsTimeUtc)
                .append("obsTimeLocal", obsTimeLocal)
                .append("epoch", epoch)
                .append("lat", lat)
                .append("lon", lon)
                .append("solarRadiationHigh", solarRadiationHigh)
                .append("uvHigh", uvHigh)
                .append("winddirAvg", winddirAvg)
                .append("humidityHigh", humidityHigh)
                .append("humidityLow", humidityLow)
                .append("humidityAvg", humidityAvg)
                .append("qcStatus", qcStatus)
                .append("metric", metric)
                .toString();
    }
}
