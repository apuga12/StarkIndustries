package mx.book.ajax.repository3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.book.ajax.domain3.TestCat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "bookAjaxRestDao")
public class JPABookAjaxRestDao implements BookAjaxRestDao {
	
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
	public String selectNextPalabraPredictiva(String dato) {
		logger.info(" ===> *** Ingreso a ==> JPABookAjaxRestDao.selectNextPalabraPredictiva(dato)");
    	return em.createNativeQuery(
    			  "SELECT palabra FROM palabra WHERE palabra like '"+dato+"%' AND ROWNUM <= 1 ORDER BY palabra"
    			).getSingleResult().toString();


	}

	@Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<TestCat> selectAll() {
        return em.createQuery("select p from TestCat p order by p.idTema").getResultList();
    }

}
