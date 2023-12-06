package com.example.netcopromax.services;

import com.example.netcopromax.models.Com;

import java.util.ArrayList;
import java.util.List;

public class ComService implements IService<Com>{
    List<Com> comList;

    public ComService() {
        this.comList = new ArrayList<>();
        comList.add(new Com(1, "Cỏ 1", 3000));
        comList.add(new Com(2, "Cỏ 2", 3000));
        comList.add(new Com(3, "Cỏ 3", 3000));
        comList.add(new Com(4, "Cỏ 4", 3000));
    }

    @Override
    public List<Com> showAll() {
        return comList;
    }

    @Override
    public void add(Com o) {
        comList.add(o);
    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < comList.size(); i++) {
            if (comList.get(i).getId() == id) return index = i;
        }
        return index;
    }

    @Override
    public Com findById(int id) {
        for (Com c: comList) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    @Override
    public List<Com> findByName(String name) {
        List<Com> findList = new ArrayList<>();
        for (Com c: comList) {
            if (c.getName().contains(name)) findList.add(c);
        }
        return findList;
    }

    @Override
    public void update(int id, Com o) {
        int index = findIndexById(id);
        comList.set(index, o);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        comList.remove(index);
    }
}
