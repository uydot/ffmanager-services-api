// Generated with g9.

package com.services.api.ffmanager.domain.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="reserva_de_sector")
public class ReservaDeSector implements Serializable {

    /** Primary key. */
    protected static final String PK = "idReservaSector";

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
    @Column(name="id_reserva_sector", unique=true, nullable=false, precision=10)
    private int idReservaSector;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_reserva", nullable=false)
    private Reservas reservas;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_sector", nullable=false)
    private Sectores sectores;

    /** Default constructor. */
    public ReservaDeSector() {
        super();
    }

    /**
     * Access method for idReservaSector.
     *
     * @return the current value of idReservaSector
     */
    public int getIdReservaSector() {
        return idReservaSector;
    }

    /**
     * Setter method for idReservaSector.
     *
     * @param aIdReservaSector the new value for idReservaSector
     */
    public void setIdReservaSector(int aIdReservaSector) {
        idReservaSector = aIdReservaSector;
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
     * Compares the key for this instance with another ReservaDeSector.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ReservaDeSector and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ReservaDeSector)) {
            return false;
        }
        ReservaDeSector that = (ReservaDeSector) other;
        if (this.getIdReservaSector() != that.getIdReservaSector()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ReservaDeSector.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ReservaDeSector)) return false;
        return this.equalKeys(other) && ((ReservaDeSector)other).equalKeys(this);
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
        i = getIdReservaSector();
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
        StringBuffer sb = new StringBuffer("[ReservaDeSector |");
        sb.append(" idReservaSector=").append(getIdReservaSector());
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
        ret.put("idReservaSector", Integer.valueOf(getIdReservaSector()));
        return ret;
    }

}
