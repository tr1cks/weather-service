
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
 * API Response
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "loc",
    "place",
    "profile",
    "obTimestamp",
    "obDateTime",
    "ob",
    "raw",
    "relativeTo"
})
public class Response {

    /**
     * Station ID
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    private String id;
    /**
     * Station Location
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("loc")
    private Loc loc;
    /**
     * Station Location Info
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("place")
    private Place place;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("profile")
    private Profile profile;
    @JsonProperty("obTimestamp")
    private Integer obTimestamp;
    @JsonProperty("obDateTime")
    private String obDateTime;
    /**
     * Observation
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ob")
    private Ob ob;
    @JsonProperty("raw")
    private String raw;
    @JsonProperty("relativeTo")
    private RelativeTo relativeTo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Station ID
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Station ID
     * <p>
     * 
     * (Required)
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Station Location
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The loc
     */
    @JsonProperty("loc")
    public Loc getLoc() {
        return loc;
    }

    /**
     * Station Location
     * <p>
     * 
     * (Required)
     * 
     * @param loc
     *     The loc
     */
    @JsonProperty("loc")
    public void setLoc(Loc loc) {
        this.loc = loc;
    }

    /**
     * Station Location Info
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The place
     */
    @JsonProperty("place")
    public Place getPlace() {
        return place;
    }

    /**
     * Station Location Info
     * <p>
     * 
     * (Required)
     * 
     * @param place
     *     The place
     */
    @JsonProperty("place")
    public void setPlace(Place place) {
        this.place = place;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The profile
     */
    @JsonProperty("profile")
    public Profile getProfile() {
        return profile;
    }

    /**
     * 
     * (Required)
     * 
     * @param profile
     *     The profile
     */
    @JsonProperty("profile")
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * 
     * @return
     *     The obTimestamp
     */
    @JsonProperty("obTimestamp")
    public Integer getObTimestamp() {
        return obTimestamp;
    }

    /**
     * 
     * @param obTimestamp
     *     The obTimestamp
     */
    @JsonProperty("obTimestamp")
    public void setObTimestamp(Integer obTimestamp) {
        this.obTimestamp = obTimestamp;
    }

    /**
     * 
     * @return
     *     The obDateTime
     */
    @JsonProperty("obDateTime")
    public String getObDateTime() {
        return obDateTime;
    }

    /**
     * 
     * @param obDateTime
     *     The obDateTime
     */
    @JsonProperty("obDateTime")
    public void setObDateTime(String obDateTime) {
        this.obDateTime = obDateTime;
    }

    /**
     * Observation
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The ob
     */
    @JsonProperty("ob")
    public Ob getOb() {
        return ob;
    }

    /**
     * Observation
     * <p>
     * 
     * (Required)
     * 
     * @param ob
     *     The ob
     */
    @JsonProperty("ob")
    public void setOb(Ob ob) {
        this.ob = ob;
    }

    /**
     * 
     * @return
     *     The raw
     */
    @JsonProperty("raw")
    public String getRaw() {
        return raw;
    }

    /**
     * 
     * @param raw
     *     The raw
     */
    @JsonProperty("raw")
    public void setRaw(String raw) {
        this.raw = raw;
    }

    /**
     * 
     * @return
     *     The relativeTo
     */
    @JsonProperty("relativeTo")
    public RelativeTo getRelativeTo() {
        return relativeTo;
    }

    /**
     * 
     * @param relativeTo
     *     The relativeTo
     */
    @JsonProperty("relativeTo")
    public void setRelativeTo(RelativeTo relativeTo) {
        this.relativeTo = relativeTo;
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
