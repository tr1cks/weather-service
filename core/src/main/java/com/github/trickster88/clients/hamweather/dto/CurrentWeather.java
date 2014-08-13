
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
    "success",
    "error",
    "response"
})
public class CurrentWeather {

    /**
     * Shows success or failure
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("success")
    private Boolean success;
    /**
     * Error object
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("error")
    private Error error;
    /**
     * API Response
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("response")
    private Response response;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Shows success or failure
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The success
     */
    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    /**
     * Shows success or failure
     * <p>
     * 
     * (Required)
     * 
     * @param success
     *     The success
     */
    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * Error object
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The error
     */
    @JsonProperty("error")
    public Error getError() {
        return error;
    }

    /**
     * Error object
     * <p>
     * 
     * (Required)
     * 
     * @param error
     *     The error
     */
    @JsonProperty("error")
    public void setError(Error error) {
        this.error = error;
    }

    /**
     * API Response
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The response
     */
    @JsonProperty("response")
    public Response getResponse() {
        return response;
    }

    /**
     * API Response
     * <p>
     * 
     * (Required)
     * 
     * @param response
     *     The response
     */
    @JsonProperty("response")
    public void setResponse(Response response) {
        this.response = response;
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
