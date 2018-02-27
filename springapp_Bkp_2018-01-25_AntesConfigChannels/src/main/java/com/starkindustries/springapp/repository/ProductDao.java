package com.starkindustries.springapp.repository;

import java.util.List;

import com.starkindustries.springapp.domain.Product;

/*
 * Interface que definirá la funcionalidad de la implementación DAO que vamos a crear, esto nos permitirá elegir
 *  en el futuro otra implementación que se adapte mejor a nuestras necesidades (p. ej. JDBC, etc.)
 * */
public interface ProductDao {
	
	public List<Product> getProductList();
    public void saveProduct(Product prod);

}
