package EJB.SERVICE;

import JPA.MODEL.VentasEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class VentasService {

    // Variables de Ordenación
    private static final String ASC = "asc";

    // Parámetros del query
    private static final String montoColumn = "monto";
    private static final String numeroColumn = "numero";
    private static final String fechaColumn = "f";
    private static final String rucColumn = "ruc";
    private static final String nombreColumn = "nombre";

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
     * Metodo que crea la consulta a la base de datos, recibe todos los parametros de la URL, y de acuerdo a ellos
     * construye el HQL.
     *
     * @param nombre    Valor del nombre de cliente
     * @param f         Fecha de la venta
     * @param numero    Numero de Venta
     * @param monto     Monto total de ventas
     * @param ruc       Ruc del Cliente
     * @param allAttributes Filtro Global
     * @param nombreOrden   Ordenacion por nombre
     * @param montoOrden    Ordenacion por monto
     * @param numeroOrd     Ordenacion por numero
     * @param fechaOrd      Ordenacion por fecha
     * @param rucOrden      Ordenacion por RUC del cliente
     *
     * @return Lista de las ventas que cumplen con los parametros especificados
     */
    @SuppressWarnings("unchecked")
    public List<VentasEntity> createQueryByParameter(String nombre, String f, String numero, String monto, String ruc, String allAttributes,
    String nombreOrden,String montoOrden, String numeroOrd, String fechaOrd, String rucOrden) {

        // Si se utiliza el filtrado global, se le otorga mayor prioridad que al resto de los filtros
        if (isValid(allAttributes)) {

            Query q = entityManager.createQuery("select v from VentasEntity v " +
                    "where nombreCliente like CONCAT(:nombre, '%') or numero like CONCAT(:numero, '%') " +
                    "or montoTotal like CONCAT(:monto, '%') or rucCliente like CONCAT(:ruc, '%') " +
                    "or fecha like CONCAT(:f, '%')");

            setParameterQuery(q, nombreColumn, allAttributes);
            setParameterQuery(q, montoColumn, allAttributes);
            setParameterQuery(q, rucColumn, allAttributes);
            setParameterQuery(q, fechaColumn, allAttributes);
            setParameterQuery(q, numeroColumn, allAttributes);
            return q.getResultList();
        }

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<VentasEntity> criteria = cb.createQuery(VentasEntity.class);

        Root<VentasEntity> ventas = criteria.from(VentasEntity.class);
        criteria.select(ventas);

        Expression<String> pathNombre = ventas.get("nombreCliente");
        Expression<String> pathMonto = ventas.get("montoTotal");
        Expression<String> pathFecha = ventas.get("fecha");
        Expression<String> pathRuc = ventas.get("rucCliente");
        Expression<String> pathNumero = ventas.get("numero");

        if(isValid(nombre)) {
            criteria.where(cb.like(pathNombre, nombre.concat("%")));

        }

        if(isValid(f)) {
            criteria.where(cb.like(pathFecha, f.concat("%")));
        }

        if(isValid(monto)) {
            criteria.where(cb.like(pathMonto, monto.concat("%")));
        }

        if(isValid(ruc)) {
            criteria.where(cb.like(pathRuc, ruc.concat("%")));
        }

        if(isValid(numero)) {
            criteria.where(cb.like(pathNumero, numero.concat("%")));
        }

        // Ordenacion
        if(isValid(numeroOrd)) {
            if(ASC.equals(numeroOrd)) {
                criteria.orderBy(cb.asc(ventas.get("numero")));
            } else {
                criteria.orderBy(cb.desc(ventas.get("numero")));
            }
        }

        if(isValid(nombreOrden)) {
            if(ASC.equals(nombreOrden)) {
                criteria.orderBy(cb.asc(ventas.get("nombreCliente")));
            } else {
                criteria.orderBy(cb.desc(ventas.get("nombreCliente")));
            }
        }

        if(isValid(montoOrden)) {
            if(ASC.equals(montoOrden)) {
                criteria.orderBy(cb.asc(ventas.get("montoTotal")));
            } else {
                criteria.orderBy(cb.desc(ventas.get("montoTotal")));
            }
        }

        if(isValid(rucOrden)) {
            if(ASC.equals(rucOrden)) {
                criteria.orderBy(cb.asc(ventas.get("rucClienteVenta")));
            } else {
                criteria.orderBy(cb.desc(ventas.get("rucClienteVenta")));
            }
        }

        if(isValid(fechaOrd)) {
            if(ASC.equals(fechaOrd)) {
                criteria.orderBy(cb.asc(ventas.get("fechaClienteVenta")));
            } else {
                criteria.orderBy(cb.desc(ventas.get("fechaClienteVenta")));
            }
        }

        return entityManager.createQuery(criteria).getResultList();
    }

    /** Crea un query a la base de datos, recibe como parámetro todos los posibles valores de
     * filtros y ordenación de las columnas. Los parámetros son extraídos de la solicitud recibida
     * al servidor.
     *
     * @param nombre        Valor del nombre del cliente
     * @param f             Valor de la fecha de la venta
     * @param numero        Valor del numero de la venta
     * @param monto         Valor del monto de venta
     * @param ruc           Valor del RUC del Cliente
     * @param allAttributes Valor del filtrado de todas las columnas
     * @return Recupera todas las ventas que coincidan con los datos proveídos
     *
     */
    @SuppressWarnings("unchecked")
    public List<VentasEntity> createQuery(String nombre, String f, String numero, String monto, String ruc, String allAttributes) {

        Query q;

        // Si se utiliza el filtrado global, se le otorga mayor prioridad que al resto de los filtros
        if (isValid(allAttributes)) {

            q = entityManager.createQuery("select v from VentasEntity v " +
                    "where nombreCliente like CONCAT(:nombre, '%') or numero like CONCAT(:numero, '%') " +
                    "or montoTotal like CONCAT(:monto, '%') or rucCliente like CONCAT(:ruc, '%') " +
                    "or fecha like CONCAT(:fecha, '%')");

            q.setParameter(nombreColumn, allAttributes);
            q.setParameter(fechaColumn, allAttributes);
            q.setParameter(numeroColumn, allAttributes);
            q.setParameter(montoColumn, allAttributes);
            q.setParameter(rucColumn, allAttributes);

            return q.getResultList();
        }

        q = entityManager.createQuery("select v from VentasEntity v " +
                "where nombreCliente like CONCAT(:nombre, '%') and numero like CONCAT(:numero, '%') " +
                "and montoTotal like CONCAT(:monto, '%') and rucCliente like CONCAT(:ruc, '%') " +
                "and fecha like CONCAT(:fecha, '%') ");

        setParameterQuery(q, nombreColumn, nombre);
        setParameterQuery(q, montoColumn, monto);
        setParameterQuery(q, rucColumn, ruc);
        setParameterQuery(q, fechaColumn, f);
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

