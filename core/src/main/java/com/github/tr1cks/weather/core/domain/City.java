package com.github.tr1cks.weather.core.domain;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class City implements Entity<Integer> {
    private Integer id;

    @NotBlank @Length(max = 100)
    private String name;
    @NotNull
    private Boolean active;
    @NotNull
    private Country country;

    public City() {}

    public City(String name, Country country, Boolean active) {
        this.setName(name);
        this.setCountry(country);
        this.setActive(active);
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;

        City city = (City) o;

        if (getActive() != null ? !getActive().equals(city.getActive()) : city.getActive() != null) return false;
        if (!getCountry().equals(city.getCountry())) return false;
        if (getId() != null ? !getId().equals(city.getId()) : city.getId() != null) return false;
        if (!getName().equals(city.getName())) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getActive() != null ? getActive().hashCode() : 0);
        result = 31 * result + getCountry().hashCode();
        return result;
    }

    @Override public String toString() {
        return Objects.toStringHelper(this)
                .add("id", getId())
                .add("name", getName())
                .add("active", getActive())
                .add("country", getCountry().getName())
                .toString();
    }
}