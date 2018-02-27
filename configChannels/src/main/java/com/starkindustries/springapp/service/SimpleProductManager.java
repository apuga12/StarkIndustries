package com.starkindustries.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.starkindustries.springapp.domain.Product;
import com.starkindustries.springapp.repository.ProductDao;

@Component
public class SimpleProductManager implements ProductManager {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts() {
        return productDao.getProductList();
    }

    public void increasePrice(int percentage) {
        List<Product> products = productDao.getProductList();
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrecio().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrecio(newPrice);
                productDao.saveProduct(product);
            }
        }
    }
}
