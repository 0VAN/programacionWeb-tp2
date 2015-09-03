package EJB.SERVICE;

import JPA.MODEL.VentasEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by alex on 31/08/15.
 */
@Stateless
public class VentasService {

    // Variables de Ordenación
    private static final String ASC = "asc";
    private static final String DESC = "desc";

    // Parámetros del query
    private static final String montoColumn = "monto";
    private static final String numeroColumn = "numero";
    private static final String fechaColumn = "fecha";
    private static final String rucColumn = "ruc";
    private static final String nombreColumn = "nombre";GASD

    @PersistenceContext(unitName = "PU")
    private EntityManager entityManager;

    @Transactional
    public void addVenta(VentasEntity ventasEntTEXI
                         Eity) {
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
     *
     * @param nombre
     * @return
     */
    public List<VentasEntity> createQueryByNombre(String nombre) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<VentasEntity> criteria = cb.createQuery(VentasEntity.class);

        Root<VentasEntity> ventas = criteria.from(VentasEntity.class);
        criteria.select(ventas).where(cb.equal(ventas.get("nombreCliente"), nombre));

        return entityManager.createQuery(criteria).getResultList();
    }

    /**
     * Crea un query a la base de datos, recibe como parámetro todos los posibles valores de
     * filtros y ordenación de las columnas. Los parámetros son extraídos de la solicitud recibida
     * al servidor.
     *
     * @param nombre        Valor del nombre del cliente
     * @param fecha         Valor de la fecha de la venta
     * @param numero        Valor del numero de la venta
     * @param monto         Valor del monto de venta
     * @param ruc           Valor del RUC del Cliente
     * @param allAttributes Valor del filtrado de todas las columnas
     * @return Recupera todas las ventas que coincidan con los datos proveídos
     */
    public List<VentasEntity> createQuery(String nombre, String fecha, String numero, String monto, String ruc, String allAttributes) {

        Query q;

        // Si se utiliza el filtrado global, se le otorga mayor prioridad que al resto de los filtros
        if (isValid(allAttributes)) {

            q = entityManager.createQuery("select v from VentasEntity v " +
                    "where nombreCliente like CONCAT(:nombre, '%') or numero like CONCAT(:numero, '%') " +
                    "or montoTotal like CONCAT(:monto, '%') or rucClienteVenta like CONCAT(:ruc, '%') " +
                    "or fechaClienteVenta like CONCAT(:fecha, '%')");

            q.setParameter(nombreColumn, allAttributes);
            q.setParameter(fechaColumn, allAttributes);
            q.setParameter(numeroColumn, allAttributes);
            q.setParameter(montoColumn, allAttributes);
            q.setParameter(rucColumn, allAttributes);

            return q.getResultList();
        }

        q = entityManager.createQuery("select v from VentasEntity v " +
                "where nombreCliente like CONCAT(:nombre, '%') and numero like CONCAT(:numero, '%') " +
                "and montoTotal like CONCAT(:monto, '%') and rucClienteVenta like CONCAT(:ruc, '%') " +
                "and fechaClienteVenta like CONCAT(:fecha, '%') ");

        setParameterQuery(q, nombreColumn, nombre);
        setParameterQuery(q, montoColumn, monto);
        setParameterQuery(q, rucColumn, ruc);
        setParameterQuery(q, fechaColumn, fecha);
        setParameterQuery(q, numeroColumn, numero);

        return q.getResultList();

    }

    /**
     * Verifica que un objeto no sea nulo
     *
     * @param obj
     * @return True si el objecto es diferente de nulo y false caso contrario
     */
    public boolean isValid(Object obj) {

        if (obj == null) {
            return false;
        }

        return true;
    }

    /**
     * Adiciona un parámetro al query
     *
     * @param q Query
     * @param nombreParametro Nombre de la Columna de la Entidad JPA
     * @param valorParametro Valor del Parametro de búsqueda
     */
    public void setParameterQuery(Query q, String nombreParametro, String valorParametro) {

        if (isValid(valorParametro)) {
            q.setParameter(nombreParametro, valorParametro);
        } else {
            q.setParameter(nombreParametro, "");
        }

    }


}

