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

@Entity(name="reserva_de_area")
public class ReservaDeArea implements Serializable {

    /** Primary key. */
    protected static final String PK = "idReservaArea";

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
    @Column(name="id_reserva_area", unique=true, nullable=false, precision=10)
    private int idReservaArea;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_area", nullable=false)
    private Areas areas;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_reserva", nullable=false)
    private Reservas reservas;

    /** Default constructor. */
    public ReservaDeArea() {
        super();
    }

    /**
     * Access method for idReservaArea.
     *
     * @return the current value of idReservaArea
     */
    public int getIdReservaArea() {
        return idReservaArea;
    }

    /**
     * Setter method for idReservaArea.
     *
     * @param aIdReservaArea the new value for idReservaArea
     */
    public void setIdReservaArea(int aIdReservaArea) {
        idReservaArea = aIdReservaArea;
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
     * Compares the key for this instance with another ReservaDeArea.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ReservaDeArea and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ReservaDeArea)) {
            return false;
        }
        ReservaDeArea that = (ReservaDeArea) other;
        if (this.getIdReservaArea() != that.getIdReservaArea()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ReservaDeArea.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ReservaDeArea)) return false;
        return this.equalKeys(other) && ((ReservaDeArea)other).equalKeys(this);
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
        i = getIdReservaArea();
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
        StringBuffer sb = new StringBuffer("[ReservaDeArea |");
        sb.append(" idReservaArea=").append(getIdReservaArea());
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
        ret.put("idReservaArea", Integer.valueOf(getIdReservaArea()));
        return ret;
    }

}
