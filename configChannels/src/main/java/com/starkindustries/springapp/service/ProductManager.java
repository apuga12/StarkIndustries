package com.starkindustries.springapp.service;

import java.io.Serializable;
import java.util.List;

import com.starkindustries.springapp.domain.Product;

public interface ProductManager extends Serializable {
    public void increasePrice(int percentage);    
    public List<Product> getProducts();

}
