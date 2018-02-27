package com.starkindustries.springapp.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.starkindustries.springapp.domain.Product;


public class JPAProductDaoTests {

    private ApplicationContext context;
    private ProductDao productDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        productDao = (ProductDao) context.getBean("productDao");
    }

    @Test
    public void testGetProductList() {
        List<Product> products = productDao.getProductList();
        assertEquals(products.size(), 10, 0);	   
        System.out.println(" \n\n ===> *** products.size() = " +products.size());
    }

    @Test
    public void testSaveProduct() {
        List<Product> products = productDao.getProductList();

        Product p = products.get(0);
        Double price = p.getPrecio();
        p.setPrecio(200.12);
        productDao.saveProduct(p);
        
        System.out.println(" \n\n ===> *** PRECIO ORIGINAL Prod_0 = "+price);
        System.out.println(" \n\n ===> *** PRECIO Modificado Prod_0 = 200.12");

        List<Product> updatedProducts = productDao.getProductList();
        Product p2 = updatedProducts.get(0);
        assertEquals(p2.getPrecio(), 200.12, 0);

        p2.setPrecio(price);
        productDao.saveProduct(p2);
    }
}