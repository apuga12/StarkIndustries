package com.starkindustries.springapp.repository;

import java.util.List;

import com.starkindustries.springapp.domain.Product;

/*
 * Interface que definir� la funcionalidad de la implementaci�n DAO que vamos a crear, esto nos permitir� elegir
 *  en el futuro otra implementaci�n que se adapte mejor a nuestras necesidades (p. ej. JDBC, etc.)
 * */
public interface ProductDao {
	
	public List<Product> getProductList();
    public void saveProduct(Product prod);

}
