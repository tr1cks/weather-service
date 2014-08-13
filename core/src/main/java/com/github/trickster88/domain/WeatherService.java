package com.github.trickster88.domain;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class WeatherService implements Entity<Integer> {
    private Integer id;

    @NotBlank @Length(min = 5)
    private String name;
    @NotNull
    private Boolean active;
    @NotNull @Min(1000)
    private Long delayInMilliseconds;

    public WeatherService() {}

    public WeatherService(String name, Long delayInMilliseconds, Boolean active) {
        this.setName(name);
        this.setDelayInMilliseconds(delayInMilliseconds);
        this.setActive(active);
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public Long getDelayInMilliseconds() { return delayInMilliseconds; }
    public void setDelayInMilliseconds(Long delayInMilliseconds) { this.delayInMilliseconds = delayInMilliseconds; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherService)) return false;

        WeatherService that = (WeatherService) o;

        if (!getName().equals(that.getName())) return false;

        return true;
    }

    @Override public int hashCode() {
        return getName().hashCode();
    }

    @Override public String toString() {
        return Objects.toStringHelper(this)
                .add("id", getId())
                .add("name", getName())
                .add("active", getActive())
                .add("delayInMilliseconds", getDelayInMilliseconds())
                .toString();
    }
}