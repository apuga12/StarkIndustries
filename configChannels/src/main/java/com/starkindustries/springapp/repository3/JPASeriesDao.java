package com.starkindustries.springapp.repository3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starkindustries.springapp.domain3.Series;
import com.starkindustries.springapp.domain3.TtcGuiaCanalesLegacy;


/*
 * JPAProductDao que será la implementación JPA de la interface anterior. 
 * Spring permite creación automática de beans de acceso a datos mediante la anotación @Repository. 
 * Asimismo, Spring reconoce las anotaciones del API estándar JPA. 
 * Ejemplo, la anotación @Persistence es utilizada en la clase JPASeriesDao para inyectar automáticamente el EntityManager.
 * */
@Repository(value = "seriesDAO")
public class JPASeriesDao implements SeriesDAO {
	
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
    public List<Series> get() {
    	logger.info(" ===> *** Ingreso a ==> JPASeriesDao.get(Lista de series)");
        return em.createQuery("select p from Series p order by p.id").getResultList();
    }
    
    @Transactional(readOnly = true)
	public Series find(Integer id) {  
    	logger.info(" ===> *** Ingreso a ==> JPASeriesDao.find(series)");
    	return (Series)em.createQuery(
    		    "SELECT c FROM Series c WHERE c.id = :id")
    		    .setParameter("id", id)
    		    .getSingleResult();
	}
    
    @Transactional(readOnly = true)
	public Integer selectNextvalSeries() {
     	
    	return Integer.parseInt(em.createNativeQuery(
    			  "SELECT CAST ( seq_series.nextval AS INT) FROM dual").getSingleResult().toString());
    			/* SELECT seq_task.nextval FROM dual ) . getSingleResult(); */

	}
    

    @Transactional(readOnly = false)
	public int create(Series series) {
    	logger.info(" ===> *** Ingreso a ==> JPASeriesDao.create(Series)");
		em.persist(series); 
		return 1;
	}


    @Transactional(readOnly = false)
	public void delete(Integer id) {
    	logger.info(" ===> *** Ingreso a ==> JPASeriesDao.delete(id)");
    	int resultado = em.createQuery(
    		    "DELETE FROM Series c WHERE c.id = :id")
    		    .setParameter("id", id).executeUpdate();
    	
    	logger.info(" ===> *** Registros afectados = "+resultado);
		
	}


	@Override
	public Series update(Series series) {
		// TODO Auto-generated method stub
		return null;
	}

	
////// *****************************
	


	@Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<TtcGuiaCanalesLegacy> getGuiaCanales(String empresa, String ciudad, String paquete) {
    	logger.info(" ===> *** Ingreso a ==> JPASeriesDao.getGuiaCanales(Lista de guía de canales)");
        //return em.createQuery("select p from Series p order by p.id").getResultList();
    	String eligePaquete = (paquete.equals("basico"))?"basico":"miniBasico";
    	
    	//if(eligePaquete.equals("basico")){
    		return em.createQuery("SELECT c FROM TtcGuiaCanalesLegacy c WHERE c.msoEmpresa = :msoEmpresa "
    			+ "AND c.ciudad = :ciudad AND c.flagMiniBasico = 'X' ")
    			.setParameter("msoEmpresa", empresa)
    			.setParameter("ciudad", ciudad)
    			.getResultList();
//    	}else{
//    		return em.createQuery("SELECT c FROM TtcGuiaCanalesLegacy c WHERE c.msoEmpresa = :msoEmpresa "
//    			+ "AND ")
//    			.setParameter("msoEmpresa", empresa)
//    			.setParameter("msoEmpresa", empresa)
//    			.getResultList();
//    	}
    	
//    	return (Series)em.createQuery(
//    		    "SELECT c FROM Series c WHERE c.id = :id")
//    		    .setParameter("id", id)
//    		    .getSingleResult();
//    	
	}
	

}
