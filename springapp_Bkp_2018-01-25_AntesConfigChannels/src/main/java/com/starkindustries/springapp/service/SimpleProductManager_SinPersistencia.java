package com.starkindustries.springapp.service;

import java.util.List;

import com.starkindustries.springapp.domain.Product;

public class SimpleProductManager_SinPersistencia implements ProductManager {

	private static final long serialVersionUID = 1L;
	
	private List<Product> products;
	
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		// Es BUENO lanzar esta Exception, cuando aún no se tienen implementados los métodos
		//throw new UnsupportedOperationException();
		
		return products;
	}
	
	public void increasePrice(int percentage) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException();
		
		if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrecio().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrecio(newPrice);
            }
        }

	}
	
	public void setProducts(List<Product> products) {
		// Es BUENO lanzar esta Exception, cuando aún no se tienen implementados los métodos
        //throw new UnsupportedOperationException();      
		this.products = products;
    }

}
