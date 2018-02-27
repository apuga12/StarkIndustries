package com.starkindustries.springapp.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starkindustries.springapp.domain.Product;


/*
 * JPAProductDao que será la implementación JPA de la interface anterior. 
 * Spring permite creación automática de beans de acceso a datos mediante la anotación @Repository. 
 * Asimismo, Spring reconoce las anotaciones del API estándar JPA. 
 * Ejemplo, la anotación @Persistence es utilizada en la clase JPAProductDao para inyectar automáticamente el EntityManager.
 * */
@Repository(value = "productDao")
public class JPAProductDao implements ProductDao {

    private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Product> getProductList() {
        return em.createQuery("select p from Product p order by p.id").getResultList();
    }

    @Transactional(readOnly = false)
    public void saveProduct(Product prod) {
        em.merge(prod);
    }

}
