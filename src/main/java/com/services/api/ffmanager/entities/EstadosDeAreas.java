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

@Entity(name="estados_de_areas")
public class EstadosDeAreas implements Serializable {

    /** Primary key. */
    protected static final String PK = "idEstadoArea";

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
    @Column(name="id_estado_area", unique=true, nullable=false, precision=10)
    private int idEstadoArea;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_area", nullable=false)
    private Areas areas;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_estado", nullable=false)
    private Estados estados;

    /** Default constructor. */
    public EstadosDeAreas() {
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
     * Access method for idEstadoArea.
     *
     * @return the current value of idEstadoArea
     */
    public int getIdEstadoArea() {
        return idEstadoArea;
    }

    /**
     * Setter method for idEstadoArea.
     *
     * @param aIdEstadoArea the new value for idEstadoArea
     */
    public void setIdEstadoArea(int aIdEstadoArea) {
        idEstadoArea = aIdEstadoArea;
    }

    /**
     * Access method for areas.
     *
     * @return the current value of areas
     */
    public Areas getAreas() {
        return areas;
    }

    /**
     * Setter method for areas.
     *
     * @param aAreas the new value for areas
     */
    public void setAreas(Areas aAreas) {
        areas = aAreas;
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
     * Compares the key for this instance with another EstadosDeAreas.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class EstadosDeAreas and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof EstadosDeAreas)) {
            return false;
        }
        EstadosDeAreas that = (EstadosDeAreas) other;
        if (this.getIdEstadoArea() != that.getIdEstadoArea()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another EstadosDeAreas.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof EstadosDeAreas)) return false;
        return this.equalKeys(other) && ((EstadosDeAreas)other).equalKeys(this);
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
        i = getIdEstadoArea();
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
        StringBuffer sb = new StringBuffer("[EstadosDeAreas |");
        sb.append(" idEstadoArea=").append(getIdEstadoArea());
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
        ret.put("idEstadoArea", Integer.valueOf(getIdEstadoArea()));
        return ret;
    }

}
