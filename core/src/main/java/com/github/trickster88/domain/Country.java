package com.github.trickster88.domain;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Country implements Entity<Integer> {
    private Integer id;

    @NotBlank @Length(max = 100)
    private String name;
    @NotBlank @Length(min = 2, max = 2)
    private String acronym;

    public Country() {}

    public Country(String name, String acronym) {
        this.setName(name);
        this.setAcronym(acronym);
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAcronym() { return acronym; }
    public void setAcronym(String acronym) { this.acronym = acronym; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        if (!getName().equals(country.getName())) return false;

        return true;
    }

    @Override public int hashCode() {
        return getName().hashCode();
    }

    @Override public String toString() {
        return Objects.toStringHelper(this)
                .add("id", getId())
                .add("name", getName())
                .add("acronym", getAcronym())
                .toString();
    }
}