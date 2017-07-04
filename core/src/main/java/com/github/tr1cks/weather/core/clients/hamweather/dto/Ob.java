
package com.github.tr1cks.weather.core.clients.hamweather.dto;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Observation
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "timestamp",
    "dateTimeISO",
    "tempC",
    "tempF",
    "dewpointC",
    "dewpointF",
    "humidity",
    "pressureMB",
    "pressureIN",
    "windKTS",
    "windKPH",
    "windMPH",
    "windDirDEG",
    "windDir",
    "flightRule",
    "visibilityKM",
    "visibilityMI",
    "weather",
    "weatherCoded",
    "weatherPrimary",
    "weatherPrimaryCoded",
    "cloudsCoded",
    "icon",
    "weatherShort",
    "heatindexF",
    "heatindexC",
    "windchillF",
    "windchillC",
    "feelslikeF",
    "feelslikeC",
    "isDay",
    "sunrise",
    "sunriseISO",
    "sunset",
    "sunsetISO"
})
public class Ob {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    private Integer timestamp;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("dateTimeISO")
    private String dateTimeISO;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("tempC")
    private Double tempC;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("tempF")
    private Double tempF;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("dewpointC")
    private Double dewpointC;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("dewpointF")
    private Double dewpointF;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("humidity")
    private Integer humidity;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pressureMB")
    private Double pressureMB;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("pressureIN")
    private Double pressureIN;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("windKTS")
    private Double windKTS;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("windKPH")
    private Double windKPH;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("windMPH")
    private Double windMPH;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("windDirDEG")
    private Double windDirDEG;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("windDir")
    private String windDir;
    @JsonProperty("flightRule")
    private String flightRule;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("visibilityKM")
    private Double visibilityKM;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("visibilityMI")
    private Double visibilityMI;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("weather")
    private String weather;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("weatherCoded")
    private String weatherCoded;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("weatherPrimary")
    private String weatherPrimary;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("weatherPrimaryCoded")
    private String weatherPrimaryCoded;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("cloudsCoded")
    private String cloudsCoded;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("icon")
    private String icon;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("weatherShort")
    private String weatherShort;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("heatindexF")
    private Double heatindexF;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("heatindexC")
    private Double heatindexC;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("windchillF")
    private Double windchillF;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("windchillC")
    private Double windchillC;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("feelslikeF")
    private Double feelslikeF;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("feelslikeC")
    private Double feelslikeC;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("isDay")
    private Boolean isDay;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sunrise")
    private Integer sunrise;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sunriseISO")
    private String sunriseISO;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sunset")
    private Integer sunset;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sunsetISO")
    private String sunsetISO;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The timestamp
     */
    @JsonProperty("timestamp")
    public Integer getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * (Required)
     * 
     * @param timestamp
     *     The timestamp
     */
    @JsonProperty("timestamp")
    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The dateTimeISO
     */
    @JsonProperty("dateTimeISO")
    public String getDateTimeISO() {
        return dateTimeISO;
    }

    /**
     * 
     * (Required)
     * 
     * @param dateTimeISO
     *     The dateTimeISO
     */
    @JsonProperty("dateTimeISO")
    public void setDateTimeISO(String dateTimeISO) {
        this.dateTimeISO = dateTimeISO;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The tempC
     */
    @JsonProperty("tempC")
    public Double getTempC() {
        return tempC;
    }

    /**
     * 
     * (Required)
     * 
     * @param tempC
     *     The tempC
     */
    @JsonProperty("tempC")
    public void setTempC(Double tempC) {
        this.tempC = tempC;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The tempF
     */
    @JsonProperty("tempF")
    public Double getTempF() {
        return tempF;
    }

    /**
     * 
     * (Required)
     * 
     * @param tempF
     *     The tempF
     */
    @JsonProperty("tempF")
    public void setTempF(Double tempF) {
        this.tempF = tempF;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The dewpointC
     */
    @JsonProperty("dewpointC")
    public Double getDewpointC() {
        return dewpointC;
    }

    /**
     * 
     * (Required)
     * 
     * @param dewpointC
     *     The dewpointC
     */
    @JsonProperty("dewpointC")
    public void setDewpointC(Double dewpointC) {
        this.dewpointC = dewpointC;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The dewpointF
     */
    @JsonProperty("dewpointF")
    public Double getDewpointF() {
        return dewpointF;
    }

    /**
     * 
     * (Required)
     * 
     * @param dewpointF
     *     The dewpointF
     */
    @JsonProperty("dewpointF")
    public void setDewpointF(Double dewpointF) {
        this.dewpointF = dewpointF;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The humidity
     */
    @JsonProperty("humidity")
    public Integer getHumidity() {
        return humidity;
    }

    /**
     * 
     * (Required)
     * 
     * @param humidity
     *     The humidity
     */
    @JsonProperty("humidity")
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The pressureMB
     */
    @JsonProperty("pressureMB")
    public Double getPressureMB() {
        return pressureMB;
    }

    /**
     * 
     * (Required)
     * 
     * @param pressureMB
     *     The pressureMB
     */
    @JsonProperty("pressureMB")
    public void setPressureMB(Double pressureMB) {
        this.pressureMB = pressureMB;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The pressureIN
     */
    @JsonProperty("pressureIN")
    public Double getPressureIN() {
        return pressureIN;
    }

    /**
     * 
     * (Required)
     * 
     * @param pressureIN
     *     The pressureIN
     */
    @JsonProperty("pressureIN")
    public void setPressureIN(Double pressureIN) {
        this.pressureIN = pressureIN;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The windKTS
     */
    @JsonProperty("windKTS")
    public Double getWindKTS() {
        return windKTS;
    }

    /**
     * 
     * (Required)
     * 
     * @param windKTS
     *     The windKTS
     */
    @JsonProperty("windKTS")
    public void setWindKTS(Double windKTS) {
        this.windKTS = windKTS;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The windKPH
     */
    @JsonProperty("windKPH")
    public Double getWindKPH() {
        return windKPH;
    }

    /**
     * 
     * (Required)
     * 
     * @param windKPH
     *     The windKPH
     */
    @JsonProperty("windKPH")
    public void setWindKPH(Double windKPH) {
        this.windKPH = windKPH;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The windMPH
     */
    @JsonProperty("windMPH")
    public Double getWindMPH() {
        return windMPH;
    }

    /**
     * 
     * (Required)
     * 
     * @param windMPH
     *     The windMPH
     */
    @JsonProperty("windMPH")
    public void setWindMPH(Double windMPH) {
        this.windMPH = windMPH;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The windDirDEG
     */
    @JsonProperty("windDirDEG")
    public Double getWindDirDEG() {
        return windDirDEG;
    }

    /**
     * 
     * (Required)
     * 
     * @param windDirDEG
     *     The windDirDEG
     */
    @JsonProperty("windDirDEG")
    public void setWindDirDEG(Double windDirDEG) {
        this.windDirDEG = windDirDEG;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The windDir
     */
    @JsonProperty("windDir")
    public String getWindDir() {
        return windDir;
    }

    /**
     * 
     * (Required)
     * 
     * @param windDir
     *     The windDir
     */
    @JsonProperty("windDir")
    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    /**
     * 
     * @return
     *     The flightRule
     */
    @JsonProperty("flightRule")
    public String getFlightRule() {
        return flightRule;
    }

    /**
     * 
     * @param flightRule
     *     The flightRule
     */
    @JsonProperty("flightRule")
    public void setFlightRule(String flightRule) {
        this.flightRule = flightRule;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The visibilityKM
     */
    @JsonProperty("visibilityKM")
    public Double getVisibilityKM() {
        return visibilityKM;
    }

    /**
     * 
     * (Required)
     * 
     * @param visibilityKM
     *     The visibilityKM
     */
    @JsonProperty("visibilityKM")
    public void setVisibilityKM(Double visibilityKM) {
        this.visibilityKM = visibilityKM;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The visibilityMI
     */
    @JsonProperty("visibilityMI")
    public Double getVisibilityMI() {
        return visibilityMI;
    }

    /**
     * 
     * (Required)
     * 
     * @param visibilityMI
     *     The visibilityMI
     */
    @JsonProperty("visibilityMI")
    public void setVisibilityMI(Double visibilityMI) {
        this.visibilityMI = visibilityMI;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The weather
     */
    @JsonProperty("weather")
    public String getWeather() {
        return weather;
    }

    /**
     * 
     * (Required)
     * 
     * @param weather
     *     The weather
     */
    @JsonProperty("weather")
    public void setWeather(String weather) {
        this.weather = weather;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The weatherCoded
     */
    @JsonProperty("weatherCoded")
    public String getWeatherCoded() {
        return weatherCoded;
    }

    /**
     * 
     * (Required)
     * 
     * @param weatherCoded
     *     The weatherCoded
     */
    @JsonProperty("weatherCoded")
    public void setWeatherCoded(String weatherCoded) {
        this.weatherCoded = weatherCoded;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The weatherPrimary
     */
    @JsonProperty("weatherPrimary")
    public String getWeatherPrimary() {
        return weatherPrimary;
    }

    /**
     * 
     * (Required)
     * 
     * @param weatherPrimary
     *     The weatherPrimary
     */
    @JsonProperty("weatherPrimary")
    public void setWeatherPrimary(String weatherPrimary) {
        this.weatherPrimary = weatherPrimary;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The weatherPrimaryCoded
     */
    @JsonProperty("weatherPrimaryCoded")
    public String getWeatherPrimaryCoded() {
        return weatherPrimaryCoded;
    }

    /**
     * 
     * (Required)
     * 
     * @param weatherPrimaryCoded
     *     The weatherPrimaryCoded
     */
    @JsonProperty("weatherPrimaryCoded")
    public void setWeatherPrimaryCoded(String weatherPrimaryCoded) {
        this.weatherPrimaryCoded = weatherPrimaryCoded;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The cloudsCoded
     */
    @JsonProperty("cloudsCoded")
    public String getCloudsCoded() {
        return cloudsCoded;
    }

    /**
     * 
     * (Required)
     * 
     * @param cloudsCoded
     *     The cloudsCoded
     */
    @JsonProperty("cloudsCoded")
    public void setCloudsCoded(String cloudsCoded) {
        this.cloudsCoded = cloudsCoded;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The icon
     */
    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    /**
     * 
     * (Required)
     * 
     * @param icon
     *     The icon
     */
    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The weatherShort
     */
    @JsonProperty("weatherShort")
    public String getWeatherShort() {
        return weatherShort;
    }

    /**
     * 
     * (Required)
     * 
     * @param weatherShort
     *     The weatherShort
     */
    @JsonProperty("weatherShort")
    public void setWeatherShort(String weatherShort) {
        this.weatherShort = weatherShort;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The heatindexF
     */
    @JsonProperty("heatindexF")
    public Double getHeatindexF() {
        return heatindexF;
    }

    /**
     * 
     * (Required)
     * 
     * @param heatindexF
     *     The heatindexF
     */
    @JsonProperty("heatindexF")
    public void setHeatindexF(Double heatindexF) {
        this.heatindexF = heatindexF;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The heatindexC
     */
    @JsonProperty("heatindexC")
    public Double getHeatindexC() {
        return heatindexC;
    }

    /**
     * 
     * (Required)
     * 
     * @param heatindexC
     *     The heatindexC
     */
    @JsonProperty("heatindexC")
    public void setHeatindexC(Double heatindexC) {
        this.heatindexC = heatindexC;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The windchillF
     */
    @JsonProperty("windchillF")
    public Double getWindchillF() {
        return windchillF;
    }

    /**
     * 
     * (Required)
     * 
     * @param windchillF
     *     The windchillF
     */
    @JsonProperty("windchillF")
    public void setWindchillF(Double windchillF) {
        this.windchillF = windchillF;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The windchillC
     */
    @JsonProperty("windchillC")
    public Double getWindchillC() {
        return windchillC;
    }

    /**
     * 
     * (Required)
     * 
     * @param windchillC
     *     The windchillC
     */
    @JsonProperty("windchillC")
    public void setWindchillC(Double windchillC) {
        this.windchillC = windchillC;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The feelslikeF
     */
    @JsonProperty("feelslikeF")
    public Double getFeelslikeF() {
        return feelslikeF;
    }

    /**
     * 
     * (Required)
     * 
     * @param feelslikeF
     *     The feelslikeF
     */
    @JsonProperty("feelslikeF")
    public void setFeelslikeF(Double feelslikeF) {
        this.feelslikeF = feelslikeF;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The feelslikeC
     */
    @JsonProperty("feelslikeC")
    public Double getFeelslikeC() {
        return feelslikeC;
    }

    /**
     * 
     * (Required)
     * 
     * @param feelslikeC
     *     The feelslikeC
     */
    @JsonProperty("feelslikeC")
    public void setFeelslikeC(Double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The isDay
     */
    @JsonProperty("isDay")
    public Boolean getIsDay() {
        return isDay;
    }

    /**
     * 
     * (Required)
     * 
     * @param isDay
     *     The isDay
     */
    @JsonProperty("isDay")
    public void setIsDay(Boolean isDay) {
        this.isDay = isDay;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The sunrise
     */
    @JsonProperty("sunrise")
    public Integer getSunrise() {
        return sunrise;
    }

    /**
     * 
     * (Required)
     * 
     * @param sunrise
     *     The sunrise
     */
    @JsonProperty("sunrise")
    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The sunriseISO
     */
    @JsonProperty("sunriseISO")
    public String getSunriseISO() {
        return sunriseISO;
    }

    /**
     * 
     * (Required)
     * 
     * @param sunriseISO
     *     The sunriseISO
     */
    @JsonProperty("sunriseISO")
    public void setSunriseISO(String sunriseISO) {
        this.sunriseISO = sunriseISO;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The sunset
     */
    @JsonProperty("sunset")
    public Integer getSunset() {
        return sunset;
    }

    /**
     * 
     * (Required)
     * 
     * @param sunset
     *     The sunset
     */
    @JsonProperty("sunset")
    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The sunsetISO
     */
    @JsonProperty("sunsetISO")
    public String getSunsetISO() {
        return sunsetISO;
    }

    /**
     * 
     * (Required)
     * 
     * @param sunsetISO
     *     The sunsetISO
     */
    @JsonProperty("sunsetISO")
    public void setSunsetISO(String sunsetISO) {
        this.sunsetISO = sunsetISO;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
