package com.web.demo.services;

import com.web.demo.model.Product;

public interface ProductService {

    public Iterable<Product> findAll();

}