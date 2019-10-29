package eu.kratochvil.pwssync.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Metric {
    private Float tempHigh;
    private Float tempLow;
    private Float tempAvg;
    private Float windspeedHigh;
    private Float windspeedLow;
    private Float windspeedAvg;
    private Float windgustHigh;
    private Float windgustLow;
    private Float windgustAvg;
    private Float dewptHigh;
    private Float dewptLow;
    private Float dewptAvg;
    private Float windchillHigh;
    private Float windchillLow;
    private Float windchillAvg;
    private Float heatindexHigh;
    private Float heatindexLow;
    private Float heatindexAvg;
    private Float pressureMax;
    private Float pressureMin;
    private Float pressureTrend;
    private Float precipRate;
    private Float precipTotal;

    public Metric() {
    }

    public Metric(Float tempHigh, Float tempLow, Float tempAvg, Float windspeedHigh, Float windspeedLow, Float windspeedAvg, Float windgustHigh, Float windgustLow, Float windgustAvg, Float dewptHigh, Float dewptLow, Float dewptAvg, Float windchillHigh, Float windchillLow, Float windchillAvg, Float heatindexHigh, Float heatindexLow, Float heatindexAvg, Float pressureMax, Float pressureMin, Float pressureTrend, Float precipRate, Float precipTotal) {
        this.tempHigh = tempHigh;
        this.tempLow = tempLow;
        this.tempAvg = tempAvg;
        this.windspeedHigh = windspeedHigh;
        this.windspeedLow = windspeedLow;
        this.windspeedAvg = windspeedAvg;
        this.windgustHigh = windgustHigh;
        this.windgustLow = windgustLow;
        this.windgustAvg = windgustAvg;
        this.dewptHigh = dewptHigh;
        this.dewptLow = dewptLow;
        this.dewptAvg = dewptAvg;
        this.windchillHigh = windchillHigh;
        this.windchillLow = windchillLow;
        this.windchillAvg = windchillAvg;
        this.heatindexHigh = heatindexHigh;
        this.heatindexLow = heatindexLow;
        this.heatindexAvg = heatindexAvg;
        this.pressureMax = pressureMax;
        this.pressureMin = pressureMin;
        this.pressureTrend = pressureTrend;
        this.precipRate = precipRate;
        this.precipTotal = precipTotal;
    }

    public Float getTempHigh() {
        return tempHigh;
    }

    public void setTempHigh(Float tempHigh) {
        this.tempHigh = tempHigh;
    }

    public Float getTempLow() {
        return tempLow;
    }

    public void setTempLow(Float tempLow) {
        this.tempLow = tempLow;
    }

    public Float getTempAvg() {
        return tempAvg;
    }

    public void setTempAvg(Float tempAvg) {
        this.tempAvg = tempAvg;
    }

    public Float getWindspeedHigh() {
        return windspeedHigh;
    }

    public void setWindspeedHigh(Float windspeedHigh) {
        this.windspeedHigh = windspeedHigh;
    }

    public Float getWindspeedLow() {
        return windspeedLow;
    }

    public void setWindspeedLow(Float windspeedLow) {
        this.windspeedLow = windspeedLow;
    }

    public Float getWindspeedAvg() {
        return windspeedAvg;
    }

    public void setWindspeedAvg(Float windspeedAvg) {
        this.windspeedAvg = windspeedAvg;
    }

    public Float getWindgustHigh() {
        return windgustHigh;
    }

    public void setWindgustHigh(Float windgustHigh) {
        this.windgustHigh = windgustHigh;
    }

    public Float getWindgustLow() {
        return windgustLow;
    }

    public void setWindgustLow(Float windgustLow) {
        this.windgustLow = windgustLow;
    }

    public Float getWindgustAvg() {
        return windgustAvg;
    }

    public void setWindgustAvg(Float windgustAvg) {
        this.windgustAvg = windgustAvg;
    }

    public Float getDewptHigh() {
        return dewptHigh;
    }

    public void setDewptHigh(Float dewptHigh) {
        this.dewptHigh = dewptHigh;
    }

    public Float getDewptLow() {
        return dewptLow;
    }

    public void setDewptLow(Float dewptLow) {
        this.dewptLow = dewptLow;
    }

    public Float getDewptAvg() {
        return dewptAvg;
    }

    public void setDewptAvg(Float dewptAvg) {
        this.dewptAvg = dewptAvg;
    }

    public Float getWindchillHigh() {
        return windchillHigh;
    }

    public void setWindchillHigh(Float windchillHigh) {
        this.windchillHigh = windchillHigh;
    }

    public Float getWindchillLow() {
        return windchillLow;
    }

    public void setWindchillLow(Float windchillLow) {
        this.windchillLow = windchillLow;
    }

    public Float getWindchillAvg() {
        return windchillAvg;
    }

    public void setWindchillAvg(Float windchillAvg) {
        this.windchillAvg = windchillAvg;
    }

    public Float getHeatindexHigh() {
        return heatindexHigh;
    }

    public void setHeatindexHigh(Float heatindexHigh) {
        this.heatindexHigh = heatindexHigh;
    }

    public Float getHeatindexLow() {
        return heatindexLow;
    }

    public void setHeatindexLow(Float heatindexLow) {
        this.heatindexLow = heatindexLow;
    }

    public Float getHeatindexAvg() {
        return heatindexAvg;
    }

    public void setHeatindexAvg(Float heatindexAvg) {
        this.heatindexAvg = heatindexAvg;
    }

    public Float getPressureMax() {
        return pressureMax;
    }

    public void setPressureMax(Float pressureMax) {
        this.pressureMax = pressureMax;
    }

    public Float getPressureMin() {
        return pressureMin;
    }

    public void setPressureMin(Float pressureMin) {
        this.pressureMin = pressureMin;
    }

    public Float getPressureTrend() {
        return pressureTrend;
    }

    public void setPressureTrend(Float pressureTrend) {
        this.pressureTrend = pressureTrend;
    }

    public Float getPrecipRate() {
        return precipRate;
    }

    public void setPrecipRate(Float precipRate) {
        this.precipRate = precipRate;
    }

    public Float getPrecipTotal() {
        return precipTotal;
    }

    public void setPrecipTotal(Float precipTotal) {
        this.precipTotal = precipTotal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("tempHigh", tempHigh)
                .append("tempLow", tempLow)
                .append("tempAvg", tempAvg)
                .append("windspeedHigh", windspeedHigh)
                .append("windspeedLow", windspeedLow)
                .append("windspeedAvg", windspeedAvg)
                .append("windgustHigh", windgustHigh)
                .append("windgustLow", windgustLow)
                .append("windgustAvg", windgustAvg)
                .append("dewptHigh", dewptHigh)
                .append("dewptLow", dewptLow)
                .append("dewptAvg", dewptAvg)
                .append("windchillHigh", windchillHigh)
                .append("windchillLow", windchillLow)
                .append("windchillAvg", windchillAvg)
                .append("heatindexHigh", heatindexHigh)
                .append("heatindexLow", heatindexLow)
                .append("heatindexAvg", heatindexAvg)
                .append("pressureMax", pressureMax)
                .append("pressureMin", pressureMin)
                .append("pressureTrend", pressureTrend)
                .append("precipRate", precipRate)
                .append("precipTotal", precipTotal)
                .toString();
    }
}
