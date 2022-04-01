// Generated with g9.

package com.services.api.ffmanager.domain.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="actividades")
public class Actividades implements Serializable {

    /** Primary key. */
    protected static final String PK = "idActividad";

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
    @Column(name="id_actividad", unique=true, nullable=false, precision=10)
    private int idActividad;
    @Column(nullable=false, length=45)
    private String nombre;
    @Column(length=255)
    private String observaciones;
    @Column(precision=10)
    private int duracion;
    @OneToMany(mappedBy="actividades")
    private Set<ActividadesDeReserva> actividadesDeReserva;

    /** Default constructor. */
    public Actividades() {
        super();
    }

    /**
     * Access method for idActividad.
     *
     * @return the current value of idActividad
     */
    public int getIdActividad() {
        return idActividad;
    }

    /**
     * Setter method for idActividad.
     *
     * @param aIdActividad the new value for idActividad
     */
    public void setIdActividad(int aIdActividad) {
        idActividad = aIdActividad;
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
     * Access method for duracion.
     *
     * @return the current value of duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Setter method for duracion.
     *
     * @param aDuracion the new value for duracion
     */
    public void setDuracion(int aDuracion) {
        duracion = aDuracion;
    }

    /**
     * Access method for actividadesDeReserva.
     *
     * @return the current value of actividadesDeReserva
     */
    public Set<ActividadesDeReserva> getActividadesDeReserva() {
        return actividadesDeReserva;
    }

    /**
     * Setter method for actividadesDeReserva.
     *
     * @param aActividadesDeReserva the new value for actividadesDeReserva
     */
    public void setActividadesDeReserva(Set<ActividadesDeReserva> aActividadesDeReserva) {
        actividadesDeReserva = aActividadesDeReserva;
    }

    /**
     * Compares the key for this instance with another Actividades.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Actividades and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Actividades)) {
            return false;
        }
        Actividades that = (Actividades) other;
        if (this.getIdActividad() != that.getIdActividad()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Actividades.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Actividades)) return false;
        return this.equalKeys(other) && ((Actividades)other).equalKeys(this);
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
        i = getIdActividad();
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
        StringBuffer sb = new StringBuffer("[Actividades |");
        sb.append(" idActividad=").append(getIdActividad());
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
        ret.put("idActividad", Integer.valueOf(getIdActividad()));
        return ret;
    }

}
