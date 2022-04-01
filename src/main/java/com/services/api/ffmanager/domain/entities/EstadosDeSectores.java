// Generated with g9.

package com.services.api.ffmanager.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="estados_de_sectores")
public class EstadosDeSectores implements Serializable {

    /** Primary key. */
    protected static final String PK = "idEstadoSector";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="LOCK_FLAG")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Column(name="fecha_asignado", nullable=false)
    private LocalDateTime fechaAsignado;
    @Id
    @Column(name="id_estado_sector", unique=true, nullable=false, precision=10)
    private int idEstadoSector;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_estado", nullable=false)
    private Estados estados;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_sector", nullable=false)
    private Sectores sectores;

    /** Default constructor. */
    public EstadosDeSectores() {
        super();
    }

    /**
     * Access method for fechaAsignado.
     *
     * @return the current value of fechaAsignado
     */
    public LocalDateTime getFechaAsignado() {
        return fechaAsignado;
    }

    /**
     * Setter method for fechaAsignado.
     *
     * @param aFechaAsignado the new value for fechaAsignado
     */
    public void setFechaAsignado(LocalDateTime aFechaAsignado) {
        fechaAsignado = aFechaAsignado;
    }

    /**
     * Access method for idEstadoSector.
     *
     * @return the current value of idEstadoSector
     */
    public int getIdEstadoSector() {
        return idEstadoSector;
    }

    /**
     * Setter method for idEstadoSector.
     *
     * @param aIdEstadoSector the new value for idEstadoSector
     */
    public void setIdEstadoSector(int aIdEstadoSector) {
        idEstadoSector = aIdEstadoSector;
    }

    /**
     * Access method for estados.
     *
     * @return the current value of estados
     */
    public Estados getEstados() {
        return estados;
    }

    /**
     * Setter method for estados.
     *
     * @param aEstados the new value for estados
     */
    public void setEstados(Estados aEstados) {
        estados = aEstados;
    }

    /**
     * Access method for sectores.
     *
     * @return the current value of sectores
     */
    public Sectores getSectores() {
        return sectores;
    }

    /**
     * Setter method for sectores.
     *
     * @param aSectores the new value for sectores
     */
    public void setSectores(Sectores aSectores) {
        sectores = aSectores;
    }

    /**
     * Compares the key for this instance with another EstadosDeSectores.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class EstadosDeSectores and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof EstadosDeSectores)) {
            return false;
        }
        EstadosDeSectores that = (EstadosDeSectores) other;
        if (this.getIdEstadoSector() != that.getIdEstadoSector()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another EstadosDeSectores.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof EstadosDeSectores)) return false;
        return this.equalKeys(other) && ((EstadosDeSectores)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getIdEstadoSector();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[EstadosDeSectores |");
        sb.append(" idEstadoSector=").append(getIdEstadoSector());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("idEstadoSector", Integer.valueOf(getIdEstadoSector()));
        return ret;
    }

}
