package com.github.tr1cks.weather.core.domain;

public interface Entity<ID> {
    ID getId();
    void setId(ID id);
}
