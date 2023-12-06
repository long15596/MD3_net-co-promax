package com.example.netcopromax.services;

import com.example.netcopromax.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IService<User>{
    List<User> userList;

    public UserService() {
        this.userList = new ArrayList<>();
        userList.add(new User(1, "a", "a", "123", 10000));
        userList.add(new User(2, "b", "b", "123", 10000));
        userList.add(new User(3, "c", "c", "123", 10000));
        userList.add(new User(4, "d", "d", "123", 10000));
    }

    @Override
    public List<User> showAll() {
        return userList;
    }

    @Override
    public void add(User o) {
        userList.add(o);
    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) index = i;
        }
        return index;
    }

    @Override
    public User findById(int id) {
        for (User u: userList){
            if (u.getId() == id) return u;
        }
        return null;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> findList = new ArrayList<>();
        for (User u: userList){
            if (u.getName().contains(name)) findList.add(u);
        }
        return findList;
    }

    @Override
    public void update(int id, User o) {
        int index = findIndexById(id);
        userList.set(index, o);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        userList.remove(index);
    }
}
