// Generated with g9.

package com.services.api.ffmanager.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="reservas")
public class Reservas implements Serializable {

    /** Primary key. */
    protected static final String PK = "idReserva";

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
    @Column(name="id_reserva", unique=true, nullable=false, precision=10)
    private int idReserva;
    @Column(name="fecha_desde")
    private LocalDateTime fechaDesde;
    @Column(name="fecha_hasta")
    private LocalDateTime fechaHasta;
    @OneToMany(mappedBy="reservas")
    private Set<ReservaDeArea> reservaDeArea;
    @OneToMany(mappedBy="reservas")
    private Set<ActividadesDeReserva> actividadesDeReserva;
    @OneToMany(mappedBy="reservas")
    private Set<MaterialesDeReserva> materialesDeReserva;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_usuario", nullable=false)
    private Usuarios usuarios;
    @OneToMany(mappedBy="reservas")
    private Set<ReservaDeSector> reservaDeSector;

    /** Default constructor. */
    public Reservas() {
        super();
    }

    /**
     * Access method for idReserva.
     *
     * @return the current value of idReserva
     */
    public int getIdReserva() {
        return idReserva;
    }

    /**
     * Setter method for idReserva.
     *
     * @param aIdReserva the new value for idReserva
     */
    public void setIdReserva(int aIdReserva) {
        idReserva = aIdReserva;
    }

    /**
     * Access method for fechaDesde.
     *
     * @return the current value of fechaDesde
     */
    public LocalDateTime getFechaDesde() {
        return fechaDesde;
    }

    /**
     * Setter method for fechaDesde.
     *
     * @param aFechaDesde the new value for fechaDesde
     */
    public void setFechaDesde(LocalDateTime aFechaDesde) {
        fechaDesde = aFechaDesde;
    }

    /**
     * Access method for fechaHasta.
     *
     * @return the current value of fechaHasta
     */
    public LocalDateTime getFechaHasta() {
        return fechaHasta;
    }

    /**
     * Setter method for fechaHasta.
     *
     * @param aFechaHasta the new value for fechaHasta
     */
    public void setFechaHasta(LocalDateTime aFechaHasta) {
        fechaHasta = aFechaHasta;
    }

    /**
     * Access method for reservaDeArea.
     *
     * @return the current value of reservaDeArea
     */
    public Set<ReservaDeArea> getReservaDeArea() {
        return reservaDeArea;
    }

    /**
     * Setter method for reservaDeArea.
     *
     * @param aReservaDeArea the new value for reservaDeArea
     */
    public void setReservaDeArea(Set<ReservaDeArea> aReservaDeArea) {
        reservaDeArea = aReservaDeArea;
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
     * Access method for materialesDeReserva.
     *
     * @return the current value of materialesDeReserva
     */
    public Set<MaterialesDeReserva> getMaterialesDeReserva() {
        return materialesDeReserva;
    }

    /**
     * Setter method for materialesDeReserva.
     *
     * @param aMaterialesDeReserva the new value for materialesDeReserva
     */
    public void setMaterialesDeReserva(Set<MaterialesDeReserva> aMaterialesDeReserva) {
        materialesDeReserva = aMaterialesDeReserva;
    }

    /**
     * Access method for usuarios.
     *
     * @return the current value of usuarios
     */
    public Usuarios getUsuarios() {
        return usuarios;
    }

    /**
     * Setter method for usuarios.
     *
     * @param aUsuarios the new value for usuarios
     */
    public void setUsuarios(Usuarios aUsuarios) {
        usuarios = aUsuarios;
    }

    /**
     * Access method for reservaDeSector.
     *
     * @return the current value of reservaDeSector
     */
    public Set<ReservaDeSector> getReservaDeSector() {
        return reservaDeSector;
    }

    /**
     * Setter method for reservaDeSector.
     *
     * @param aReservaDeSector the new value for reservaDeSector
     */
    public void setReservaDeSector(Set<ReservaDeSector> aReservaDeSector) {
        reservaDeSector = aReservaDeSector;
    }

    /**
     * Compares the key for this instance with another Reservas.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Reservas and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Reservas)) {
            return false;
        }
        Reservas that = (Reservas) other;
        if (this.getIdReserva() != that.getIdReserva()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Reservas.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Reservas)) return false;
        return this.equalKeys(other) && ((Reservas)other).equalKeys(this);
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
        i = getIdReserva();
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
        StringBuffer sb = new StringBuffer("[Reservas |");
        sb.append(" idReserva=").append(getIdReserva());
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
        ret.put("idReserva", Integer.valueOf(getIdReserva()));
        return ret;
    }

}
