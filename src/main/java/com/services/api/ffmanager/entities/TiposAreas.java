// Generated with g9.

package com.services.api.ffmanager.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="tipos_areas")
public class TiposAreas implements Serializable {

    /** Primary key. */
    protected static final String PK = "idTipoArea";

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

    @Id
    @Column(name="id_tipo_area", unique=true, nullable=false, precision=10)
    private int idTipoArea;
    @Column(length=255)
    private String nombre;
    @Column(length=255)
    private String descripcion;
    @Column(name="es_techada", nullable=false, length=1)
    private boolean esTechada;
    @Column(length=255)
    private String observaciones;
    @Column(name="es_compuesta", nullable=false, length=1)
    private boolean esCompuesta;
    @OneToMany(mappedBy="tiposAreas")
    private Set<Areas> areas;

    /** Default constructor. */
    public TiposAreas() {
        super();
    }

    /**
     * Access method for idTipoArea.
     *
     * @return the current value of idTipoArea
     */
    public int getIdTipoArea() {
        return idTipoArea;
    }

    /**
     * Setter method for idTipoArea.
     *
     * @param aIdTipoArea the new value for idTipoArea
     */
    public void setIdTipoArea(int aIdTipoArea) {
        idTipoArea = aIdTipoArea;
    }

    /**
     * Access method for nombre.
     *
     * @return the current value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter method for nombre.
     *
     * @param aNombre the new value for nombre
     */
    public void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * Access method for descripcion.
     *
     * @return the current value of descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter method for descripcion.
     *
     * @param aDescripcion the new value for descripcion
     */
    public void setDescripcion(String aDescripcion) {
        descripcion = aDescripcion;
    }

    /**
     * Access method for esTechada.
     *
     * @return true if and only if esTechada is currently true
     */
    public boolean isEsTechada() {
        return esTechada;
    }

    /**
     * Setter method for esTechada.
     *
     * @param aEsTechada the new value for esTechada
     */
    public void setEsTechada(boolean aEsTechada) {
        esTechada = aEsTechada;
    }

    /**
     * Access method for observaciones.
     *
     * @return the current value of observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Setter method for observaciones.
     *
     * @param aObservaciones the new value for observaciones
     */
    public void setObservaciones(String aObservaciones) {
        observaciones = aObservaciones;
    }

    /**
     * Access method for esCompuesta.
     *
     * @return true if and only if esCompuesta is currently true
     */
    public boolean isEsCompuesta() {
        return esCompuesta;
    }

    /**
     * Setter method for esCompuesta.
     *
     * @param aEsCompuesta the new value for esCompuesta
     */
    public void setEsCompuesta(boolean aEsCompuesta) {
        esCompuesta = aEsCompuesta;
    }

    /**
     * Access method for areas.
     *
     * @return the current value of areas
     */
    public Set<Areas> getAreas() {
        return areas;
    }

    /**
     * Setter method for areas.
     *
     * @param aAreas the new value for areas
     */
    public void setAreas(Set<Areas> aAreas) {
        areas = aAreas;
    }

    /**
     * Compares the key for this instance with another TiposAreas.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class TiposAreas and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof TiposAreas)) {
            return false;
        }
        TiposAreas that = (TiposAreas) other;
        if (this.getIdTipoArea() != that.getIdTipoArea()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another TiposAreas.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TiposAreas)) return false;
        return this.equalKeys(other) && ((TiposAreas)other).equalKeys(this);
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
        i = getIdTipoArea();
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
        StringBuffer sb = new StringBuffer("[TiposAreas |");
        sb.append(" idTipoArea=").append(getIdTipoArea());
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
        ret.put("idTipoArea", Integer.valueOf(getIdTipoArea()));
        return ret;
    }

}
