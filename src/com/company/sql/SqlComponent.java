package com.company.sql;

import java.util.List;

public interface SqlComponent<key, T> {

    T getFirstById(key id);
    List<T> getAll();

    void insert(T component);
    void insertAll(List<T> component);
}
