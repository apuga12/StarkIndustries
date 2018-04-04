package com.starkindustries.springapp.repository2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.book.ajax.vo3.Categoria;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starkindustries.springapp.domain2.User;

/*
 * JPAProductDao que será la implementación JPA de la interface anterior. 
 * Spring permite creación automática de beans de acceso a datos mediante la anotación @Repository. 
 * Asimismo, Spring reconoce las anotaciones del API estándar JPA. 
 * Ejemplo, la anotación @Persistence es utilizada en la clase JPAProductDao para inyectar automáticamente el EntityManager.
 * */
@Repository(value = "userDao")
public class JPAUserDao implements UserDao {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
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
    public List<User> selectAll() {
        return em.createQuery("select p from User p order by p.id").getResultList();
    }
    
    @Transactional(readOnly = true)
    //@SuppressWarnings("unchecked")
	public User selectById(Integer id) {
    	
    	//return (User)em.createNamedQuery("find User by id").setParameter("id", id).getSingleResult();
        //query.setParameter("id", 1204);
    	
    	return (User)em.createQuery(
    		    "SELECT c FROM User c WHERE c.id = :id")
    		    .setParameter("id", id)
    		    .getSingleResult();
	}
    
    @Transactional(readOnly = true)
	public Integer selectNextvalUser() {
     	
    	return Integer.parseInt(em.createNativeQuery(
    			  "SELECT CAST ( seq_user.nextval AS INT) FROM dual").getSingleResult().toString());
    			/* SELECT seq_task.nextval FROM dual ) . getSingleResult(); */

	}
    
    @Transactional(readOnly = false)
    public int insertUser(User user) {
    	logger.info(" ===> *** Ingreso a ==> insertUser(user)");
        //em.merge(user);
    	em.persist(user);
        return 0;
    }
    
    @Transactional(readOnly = false)
    public boolean isRegistered(String log, String pwd){
    	try{
	    	logger.info(" ===> *** Ingreso a ==> isRegistered(log,pwd) ");
	    	int logVal = Integer.parseInt(em.createNativeQuery(
	  			  "SELECT COUNT(*) FROM MYUSER WHERE LOGIN = '"+log+"' AND PASSWORD = '"+pwd+"' ").getSingleResult().toString());   
	    	if(logVal > 0)
	    		return true;
	    	else
	    		return false;
    	} catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    }
    
    @Transactional(readOnly = false)
    public List<Categoria> selectAllCategories(){
    	try{
	    	StringBuffer query = new StringBuffer();
	    	query.append("SELECT ID, DESCRIPCION FROM CATEGORIAS ");
	    	//query.append("   where CNP_IDPACK =(select pac_id from CV_PACKS where PAC_NAME =:paqNombre) ");
			//query.append("   and ID_RPT = (select RPT_CODE from TT_RPT where RPT_NAME =:ciudad))   ");
			query.append(" ORDER BY DESCRIPCION ");
			//javax.persistence.Query jpaQuery = em.createNativeQuery(query.toString(), Categoria.class);   <=== Por si mapeamos con clase Entity
			javax.persistence.Query jpaQuery = em.createNativeQuery(query.toString());
			//jpaQuery.setParameter("paqNombre", paqNombre);
			//jpaQuery.setParameter("ciudad", ciudad);
			List<Categoria> lista = new ArrayList<Categoria>();
			List<Object[]> listaObj = (List<Object[]>) jpaQuery.getResultList();		
			Categoria categoria = null;
			for (Object[] rptObj : listaObj) {			
				BigDecimal gponObj = (BigDecimal) rptObj[0];
				Long gpon = null;
				if (gponObj != null) {
					gpon = gponObj.longValue();
				}
				categoria = new Categoria();
				categoria.setId(gpon);
				categoria.setDescripcion((String)rptObj[1]);
				lista.add(categoria);
				logger.info(categoria.toString()); 
			}		
			return lista;
    	} catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }

}
