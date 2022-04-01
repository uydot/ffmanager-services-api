// Generated with g9.

package com.services.api.ffmanager.entities;

import java.io.Serializable;
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

@Entity(name="sectores")
public class Sectores implements Serializable {

    /** Primary key. */
    protected static final String PK = "idSector";

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
    @Column(name="id_sector", unique=true, nullable=false, precision=10)
    private int idSector;
    @Column(nullable=false, length=255)
    private String nombre;
    @Column(length=255)
    private String observaciones;
    @Column(name="tamaño", precision=22)
    private double tamano;
    @Column(name="es_sector_golero", nullable=false, length=1)
    private boolean esSectorGolero;
    @Column(name="numero_sector", nullable=false, precision=10)
    private int numeroSector;
    @OneToMany(mappedBy="sectores")
    private Set<EstadosDeSectores> estadosDeSectores;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_area", nullable=false)
    private Areas areas;
    @OneToMany(mappedBy="sectores")
    private Set<ReservaDeSector> reservaDeSector;

    /** Default constructor. */
    public Sectores() {
        super();
    }

    /**
     * Access method for idSector.
     *
     * @return the current value of idSector
     */
    public int getIdSector() {
        return idSector;
    }

    /**
     * Setter method for idSector.
     *
     * @param aIdSector the new value for idSector
     */
    public void setIdSector(int aIdSector) {
        idSector = aIdSector;
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
     * Access method for tamano.
     *
     * @return the current value of tamano
     */
    public double getTamano() {
        return tamano;
    }

    /**
     * Setter method for tamano.
     *
     * @param aTamano the new value for tamano
     */
    public void setTamano(double aTamano) {
        tamano = aTamano;
    }

    /**
     * Access method for esSectorGolero.
     *
     * @return true if and only if esSectorGolero is currently true
     */
    public boolean isEsSectorGolero() {
        return esSectorGolero;
    }

    /**
     * Setter method for esSectorGolero.
     *
     * @param aEsSectorGolero the new value for esSectorGolero
     */
    public void setEsSectorGolero(boolean aEsSectorGolero) {
        esSectorGolero = aEsSectorGolero;
    }

    /**
     * Access method for numeroSector.
     *
     * @return the current value of numeroSector
     */
    public int getNumeroSector() {
        return numeroSector;
    }

    /**
     * Setter method for numeroSector.
     *
     * @param aNumeroSector the new value for numeroSector
     */
    public void setNumeroSector(int aNumeroSector) {
        numeroSector = aNumeroSector;
    }

    /**
     * Access method for estadosDeSectores.
     *
     * @return the current value of estadosDeSectores
     */
    public Set<EstadosDeSectores> getEstadosDeSectores() {
        return estadosDeSectores;
    }

    /**
     * Setter method for estadosDeSectores.
     *
     * @param aEstadosDeSectores the new value for estadosDeSectores
     */
    public void setEstadosDeSectores(Set<EstadosDeSectores> aEstadosDeSectores) {
        estadosDeSectores = aEstadosDeSectores;
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
     * Compares the key for this instance with another Sectores.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Sectores and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Sectores)) {
            return false;
        }
        Sectores that = (Sectores) other;
        if (this.getIdSector() != that.getIdSector()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Sectores.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Sectores)) return false;
        return this.equalKeys(other) && ((Sectores)other).equalKeys(this);
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
        i = getIdSector();
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
        StringBuffer sb = new StringBuffer("[Sectores |");
        sb.append(" idSector=").append(getIdSector());
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
        ret.put("idSector", Integer.valueOf(getIdSector()));
        return ret;
    }

}
