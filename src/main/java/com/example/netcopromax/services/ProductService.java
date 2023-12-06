package com.example.netcopromax.services;

import com.example.netcopromax.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IService<Product>{
    List<Product> productList;

    public ProductService() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "a", 100));
        productList.add(new Product(2, "b", 200));
        productList.add(new Product(3, "c", 300));
    }

    @Override
    public List<Product> showAll() {
        return productList;
    }

    @Override
    public void add(Product o) {
        productList.add(o);
    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) index = i;
        }
        return index;
    }

    @Override
    public Product findById(int id) {
        for (Product p: productList) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public void update(int id, Product o) {
        int index = findIndexById(id);
        productList.set(index, o);
    }

    @Override
    public void delete(int id) {
        int index =  findIndexById(id);
        productList.remove(index);
    }
}
