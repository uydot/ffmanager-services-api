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

@Entity(name="materiales_de_reserva")
public class MaterialesDeReserva implements Serializable {

    /** Primary key. */
    protected static final String PK = "idMaterialReserva";

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
    @Column(name="id_material_reserva", unique=true, nullable=false, precision=10)
    private int idMaterialReserva;
    @Column(nullable=false, precision=10)
    private int cantidad;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_material", nullable=false)
    private Materiales materiales;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_reserva", nullable=false)
    private Reservas reservas;

    /** Default constructor. */
    public MaterialesDeReserva() {
        super();
    }

    /**
     * Access method for idMaterialReserva.
     *
     * @return the current value of idMaterialReserva
     */
    public int getIdMaterialReserva() {
        return idMaterialReserva;
    }

    /**
     * Setter method for idMaterialReserva.
     *
     * @param aIdMaterialReserva the new value for idMaterialReserva
     */
    public void setIdMaterialReserva(int aIdMaterialReserva) {
        idMaterialReserva = aIdMaterialReserva;
    }

    /**
     * Access method for cantidad.
     *
     * @return the current value of cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Setter method for cantidad.
     *
     * @param aCantidad the new value for cantidad
     */
    public void setCantidad(int aCantidad) {
        cantidad = aCantidad;
    }

    /**
     * Access method for materiales.
     *
     * @return the current value of materiales
     */
    public Materiales getMateriales() {
        return materiales;
    }

    /**
     * Setter method for materiales.
     *
     * @param aMateriales the new value for materiales
     */
    public void setMateriales(Materiales aMateriales) {
        materiales = aMateriales;
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
     * Compares the key for this instance with another MaterialesDeReserva.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class MaterialesDeReserva and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof MaterialesDeReserva)) {
            return false;
        }
        MaterialesDeReserva that = (MaterialesDeReserva) other;
        if (this.getIdMaterialReserva() != that.getIdMaterialReserva()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another MaterialesDeReserva.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MaterialesDeReserva)) return false;
        return this.equalKeys(other) && ((MaterialesDeReserva)other).equalKeys(this);
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
        i = getIdMaterialReserva();
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
        StringBuffer sb = new StringBuffer("[MaterialesDeReserva |");
        sb.append(" idMaterialReserva=").append(getIdMaterialReserva());
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
        ret.put("idMaterialReserva", Integer.valueOf(getIdMaterialReserva()));
        return ret;
    }

}
