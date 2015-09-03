package JPA.MODEL;

import javax.persistence.*;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "ventas.findAll", query = "select v from VentasEntity v"),
        @NamedQuery(name = "ventas.findById", query = "select v from VentasEntity v where v.id=:id"),
        @NamedQuery(name = "ventas.findClienteAsc", query = "select v from VentasEntity v order by v.nombreCliente"),
        @NamedQuery(name = "ventas.findClienteDesc", query = "select v from VentasEntity v order by v.nombreCliente DESC "),
        @NamedQuery(name = "ventas.getTotalCount", query = "select count(v) from VentasEntity v"),

})

@Table(name = "ventas", schema = "public", catalog = "ventas")
public class VentasEntity {
    private int id;
    private String numero;
    private String montoTotal;
    private String nombreCliente;
    private String rucClienteVenta;
    private String fechaClienteVenta;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "numero", nullable = true, insertable = true, updatable = true)
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "monto_total", nullable = true, insertable = true, updatable = true)
    public String getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(String montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Basic
    @Column(name = "nombre_cliente", nullable = true, insertable = true, updatable = true, length = 50)
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Basic
    @Column(name = "ruc_cliente", nullable = true, insertable = true, updatable = true)
    public String getRucClienteVenta() {
        return rucClienteVenta;
    }

    public void setRucClienteVenta(String rucCliente) {
        this.rucClienteVenta = rucCliente;
    }

    @Basic
    @Column(name = "fecha", nullable = true, insertable = true, updatable = true)
    public String getFechaClienteVenta() {
        return fechaClienteVenta;
    }

    public void setFechaClienteVenta(String fecha) {
        this.fechaClienteVenta = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VentasEntity that = (VentasEntity) o;

        if (id != that.id) return false;
        if (fechaClienteVenta != null ? !fechaClienteVenta.equals(that.fechaClienteVenta) : that.fechaClienteVenta != null) return false;
        if (montoTotal != null ? !montoTotal.equals(that.montoTotal) : that.montoTotal != null) return false;
        if (nombreCliente != null ? !nombreCliente.equals(that.nombreCliente) : that.nombreCliente != null)
            return false;
        if (numero != null ? !numero.equals(that.numero) : that.numero != null) return false;
        if (rucClienteVenta != null ? !rucClienteVenta.equals(that.rucClienteVenta) : that.rucClienteVenta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        result = 31 * result + (montoTotal != null ? montoTotal.hashCode() : 0);
        result = 31 * result + (nombreCliente != null ? nombreCliente.hashCode() : 0);
        result = 31 * result + (rucClienteVenta != null ? rucClienteVenta.hashCode() : 0);
        result = 31 * result + (fechaClienteVenta != null ? fechaClienteVenta.hashCode() : 0);
        return result;
    }
}
