// Generated with g9.

package com.services.api.ffmanager.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="actividades_de_reserva")
public class ActividadesDeReserva implements Serializable {

    /** Primary key. */
    protected static final String PK = "idActividadReserva";

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
    @Column(name="id_actividad_reserva", unique=true, nullable=false, precision=10)
    private int idActividadReserva;
    @Column(precision=10)
    private int duracion;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_actividad", nullable=false)
    private Actividades actividades;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_reserva", nullable=false)
    private Reservas reservas;

    /** Default constructor. */
    public ActividadesDeReserva() {
        super();
    }

    /**
     * Access method for idActividadReserva.
     *
     * @return the current value of idActividadReserva
     */
    public int getIdActividadReserva() {
        return idActividadReserva;
    }

    /**
     * Setter method for idActividadReserva.
     *
     * @param aIdActividadReserva the new value for idActividadReserva
     */
    public void setIdActividadReserva(int aIdActividadReserva) {
        idActividadReserva = aIdActividadReserva;
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
     * Access method for actividades.
     *
     * @return the current value of actividades
     */
    public Actividades getActividades() {
        return actividades;
    }

    /**
     * Setter method for actividades.
     *
     * @param aActividades the new value for actividades
     */
    public void setActividades(Actividades aActividades) {
        actividades = aActividades;
    }

    /**
     * Access method for reservas.
     *
     * @return the current value of reservas
     */
    public Reservas getReservas() {
        return reservas;
    }

    /**
     * Setter method for reservas.
     *
     * @param aReservas the new value for reservas
     */
    public void setReservas(Reservas aReservas) {
        reservas = aReservas;
    }

    /**
     * Compares the key for this instance with another ActividadesDeReserva.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ActividadesDeReserva and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ActividadesDeReserva)) {
            return false;
        }
        ActividadesDeReserva that = (ActividadesDeReserva) other;
        if (this.getIdActividadReserva() != that.getIdActividadReserva()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ActividadesDeReserva.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ActividadesDeReserva)) return false;
        return this.equalKeys(other) && ((ActividadesDeReserva)other).equalKeys(this);
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
        i = getIdActividadReserva();
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
        StringBuffer sb = new StringBuffer("[ActividadesDeReserva |");
        sb.append(" idActividadReserva=").append(getIdActividadReserva());
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
        ret.put("idActividadReserva", Integer.valueOf(getIdActividadReserva()));
        return ret;
    }

}
