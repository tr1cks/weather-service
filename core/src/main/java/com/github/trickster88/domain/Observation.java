package com.github.trickster88.domain;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

//TODO: add component objects for sun, wind
public class Observation implements Entity<Integer> {
    private Integer id;

    @NotNull
    private WeatherService weatherService;
    @NotNull
    private City city;

    @NotNull @Past
    private Date dateTime;

    @NotNull
    private Double temperature;
    @NotNull @Range(min = 0, max = 100)
    private Byte humidity;
    @NotNull @Min(0)
    private Double pressure;

    @NotNull
    private Double windSpeed;
    @NotBlank @Length(max = 3)
    private String windDirection;
    @NotNull
    private Double windDirectionInDegrees;

    @NotNull
    private Date sunrise;
    @NotNull
    private Date sunset;

    public Observation() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public WeatherService getWeatherService() { return weatherService; }
    public void setWeatherService(WeatherService weatherService) { this.weatherService = weatherService; }

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }

    public Date getDateTime() { return dateTime; }
    public void setDateTime(Date dateTime) { this.dateTime = dateTime; }

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public Byte getHumidity() { return humidity; }
    public void setHumidity(Byte humidity) { this.humidity = humidity; }

    public Double getPressure() { return pressure; }
    public void setPressure(Double pressure) { this.pressure = pressure; }

    public Double getWindSpeed() { return windSpeed; }
    public void setWindSpeed(Double windSpeed) { this.windSpeed = windSpeed; }

    public Double getWindDirectionInDegrees() { return windDirectionInDegrees; }
    public void setWindDirectionInDegrees(Double windDirectionInDegrees) { this.windDirectionInDegrees = windDirectionInDegrees; }

    public String getWindDirection() { return windDirection; }
    public void setWindDirection(String windDirection) { this.windDirection = windDirection; }

    public Date getSunrise() { return sunrise; }
    public void setSunrise(Date sunrise) { this.sunrise = sunrise; }

    public Date getSunset() { return sunset; }
    public void setSunset(Date sunset) { this.sunset = sunset; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Observation)) return false;

        Observation that = (Observation) o;

        if (!getCity().equals(that.getCity())) return false;
        if (!getDateTime().equals(that.getDateTime())) return false;
        if (!getWeatherService().equals(that.getWeatherService())) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = getWeatherService().hashCode();
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getDateTime().hashCode();
        return result;
    }

    @Override public String toString() {
        return Objects.toStringHelper(this)
                .add("id", getId())
                .add("weatherService", getWeatherService().getName())
                .add("city", getCity().getName() + ',' + getCity().getCountry().getAcronym())
                .add("dateTime", getDateTime())
                .add("temperature", getTemperature())
                .add("humidity", getHumidity())
                .add("pressure", getPressure())
                .add("windSpeed", getWindSpeed())
                .add("windDirection", getWindDirection())
                .add("windDirectionInDegrees", getWindDirectionInDegrees())
                .add("sunrise", getSunrise())
                .add("sunset", getSunset())
                .toString();
    }
}