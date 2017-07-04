package com.github.tr1cks.weather.core.dao;

import com.github.tr1cks.weather.core.domain.Entity;

import javax.annotation.Nullable;

public interface DAO<ID, T extends Entity<ID>> {
    @Nullable T get(ID id);
}
