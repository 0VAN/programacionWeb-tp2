package EJB.SERVICE;

import JPA.MODEL.VentasEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.annotations.Where;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by alex on 31/08/15.
 */
@Stateless
public class VentasService {

    private static final String ASC = "asc";
    private static final String DESC = "desc";

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




    /**
     * Recupera todas las ventas del cliente dado como parametro
     * @param nombre
     * @return
     */
    public List<VentasEntity> createQuery2 (String nombre) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<VentasEntity> criteria = cb.createQuery(VentasEntity.class);

        Root<VentasEntity> ventas = criteria.from(VentasEntity.class);
        criteria.select(ventas).where(cb.equal(ventas.get("nombreCliente"), nombre));

        return entityManager.createQuery(criteria).getResultList();
    }
    public List<VentasEntity> createQuery(String nombre, String fecha, String numero, String monto, String ruc, String allAttributes) {

        Query q = entityManager.createQuery("select v from VentasEntity v " +
                "where nombreCliente like CONCAT(:nombre, '%') and numero like CONCAT(:numero, '%') " +
                "and montoTotal like CONCAT(:monto, '%') and rucCliente like CONCAT(:ruc, '%') " +
                "and fecha like CONCAT(:fecha, '%') ");

        if(nombre.equals("") || isValid(nombre)) {
            q.setParameter("nombre", nombre);
        }else if(isValid(allAttributes)){
            q.setParameter("nombre", allAttributes);
        }else {
            q.setParameter("nombre", "");
        }

        if(isValid(fecha)) {
            q.setParameter("fecha", fecha);
        } else if(isValid(allAttributes)){
            q.setParameter("fecha", allAttributes);
        }else {
            q.setParameter("fecha", "");
        }

        if (isValid(numero)) {
            q.setParameter("numero", numero);
        }else if(isValid(allAttributes)){
            q.setParameter("numero", allAttributes);
        } else {
            q.setParameter("numero", "");
        }

        if(isValid(monto)) {
            q.setParameter("monto", monto);
        }else if(isValid(allAttributes)){
            q.setParameter("monto", allAttributes);
        } else {
            q.setParameter("monto", "");
        }

        if(isValid(ruc)) {
            q.setParameter("ruc", ruc);
        }else if(isValid(allAttributes)){
            q.setParameter("ruc", allAttributes);
        } else {
            q.setParameter("ruc", "");
        }

        return q.getResultList();

    }

    public boolean isValid(Object obj) {

        if(obj == null) {
            return false;
        }

        return true;
    }

}

