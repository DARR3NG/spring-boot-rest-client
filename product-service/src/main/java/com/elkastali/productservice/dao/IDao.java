package com.elkastali.productservice.dao;

import java.util.List;

public interface IDao <T>{
    T create(T o);
    T update(Long id,T o);
    Boolean delete(Long id);
    T findById(Long id);
    List<T>findAll();
}
