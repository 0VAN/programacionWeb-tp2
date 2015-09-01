package EJB.SERVICE;

import JPA.MODEL.VentasEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by alex on 31/08/15.
 */
@Stateless

public class VentasService {

    @PersistenceContext(unitName = "PU")
    private EntityManager entityManager;

    @Transactional
    public void addVenta(VentasEntity ventasEntity) {
        entityManager.persist(ventasEntity);
    }

    @Transactional
    public void deleteVenta(VentasEntity ventasEntity) {
        entityManager.remove(ventasEntity);
    }

    @Transactional
    public void editVenta(VentasEntity ventasEntity) {
        entityManager.merge(ventasEntity);
    }

    public List getVentas() {
        Query query = entityManager.createNamedQuery("ventas.findAll");
        return query.getResultList();
    }

    public Object getVenta(int id) {
        Query query = entityManager.createNamedQuery("ventas.findById").setParameter("id", id);
        return query.getResultList().get(0);
    }
}
