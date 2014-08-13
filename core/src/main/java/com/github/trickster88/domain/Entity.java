package com.github.trickster88.domain;

public interface Entity<ID> {
    ID getId();
    void setId(ID id);
}
