package com.codegym.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    void save(T object);
    void update(T object);
    T findById(int id);
    void delete(int id);

}
