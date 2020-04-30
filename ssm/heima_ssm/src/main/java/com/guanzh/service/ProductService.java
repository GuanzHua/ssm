package com.guanzh.service;

import com.guanzh.domain.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    void save(Product product);
}
