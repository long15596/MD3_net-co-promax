package com.example.netcopromax.services;

import java.util.List;

public interface IService <O>{
    List<O> showAll();
    void add(O o);
    int findIndexById(int id);
    O findById(int id);
    List<O> findByName(String name);
    void update(int id, O o);
    void delete(int id);
}
