
package com.github.trickster88.clients.hamweather.dto;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "lat",
    "long",
    "distanceKM",
    "distanceMI",
    "bearing",
    "bearingDEG"
})
public class RelativeTo {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lat")
    private Double lat;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("long")
    private Double _long;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("distanceKM")
    private Double distanceKM;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("distanceMI")
    private Double distanceMI;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("bearing")
    private String bearing;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("bearingDEG")
    private Integer bearingDEG;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The lat
     */
    @JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    /**
     * 
     * (Required)
     * 
     * @param lat
     *     The lat
     */
    @JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The _long
     */
    @JsonProperty("long")
    public Double getLong() {
        return _long;
    }

    /**
     * 
     * (Required)
     * 
     * @param _long
     *     The long
     */
    @JsonProperty("long")
    public void setLong(Double _long) {
        this._long = _long;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The distanceKM
     */
    @JsonProperty("distanceKM")
    public Double getDistanceKM() {
        return distanceKM;
    }

    /**
     * 
     * (Required)
     * 
     * @param distanceKM
     *     The distanceKM
     */
    @JsonProperty("distanceKM")
    public void setDistanceKM(Double distanceKM) {
        this.distanceKM = distanceKM;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The distanceMI
     */
    @JsonProperty("distanceMI")
    public Double getDistanceMI() {
        return distanceMI;
    }

    /**
     * 
     * (Required)
     * 
     * @param distanceMI
     *     The distanceMI
     */
    @JsonProperty("distanceMI")
    public void setDistanceMI(Double distanceMI) {
        this.distanceMI = distanceMI;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The bearing
     */
    @JsonProperty("bearing")
    public String getBearing() {
        return bearing;
    }

    /**
     * 
     * (Required)
     * 
     * @param bearing
     *     The bearing
     */
    @JsonProperty("bearing")
    public void setBearing(String bearing) {
        this.bearing = bearing;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The bearingDEG
     */
    @JsonProperty("bearingDEG")
    public Integer getBearingDEG() {
        return bearingDEG;
    }

    /**
     * 
     * (Required)
     * 
     * @param bearingDEG
     *     The bearingDEG
     */
    @JsonProperty("bearingDEG")
    public void setBearingDEG(Integer bearingDEG) {
        this.bearingDEG = bearingDEG;
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
