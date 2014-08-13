package com.github.trickster88.dao;

import com.github.trickster88.domain.Entity;

import javax.annotation.Nullable;

public interface DAO<ID, T extends Entity<ID>> {
    @Nullable T get(ID id);
}
