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

@Entity(name="estados")
public class Estados implements Serializable {

    /** Primary key. */
    protected static final String PK = "idEstado";

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
    @Column(name="id_estado", unique=true, nullable=false, precision=10)
    private int idEstado;
    @Column(nullable=false, length=255)
    private String nombre;
    @Column(length=255)
    private String observaciones;
    @Column(name="permite_usar", nullable=false, length=1)
    private boolean permiteUsar;
    @OneToMany(mappedBy="estados")
    private Set<EstadosDeAreas> estadosDeAreas;
    @OneToMany(mappedBy="estados")
    private Set<EstadosDeSectores> estadosDeSectores;

    /** Default constructor. */
    public Estados() {
        super();
    }

    /**
     * Access method for idEstado.
     *
     * @return the current value of idEstado
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * Setter method for idEstado.
     *
     * @param aIdEstado the new value for idEstado
     */
    public void setIdEstado(int aIdEstado) {
        idEstado = aIdEstado;
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
     * Access method for permiteUsar.
     *
     * @return true if and only if permiteUsar is currently true
     */
    public boolean isPermiteUsar() {
        return permiteUsar;
    }

    /**
     * Setter method for permiteUsar.
     *
     * @param aPermiteUsar the new value for permiteUsar
     */
    public void setPermiteUsar(boolean aPermiteUsar) {
        permiteUsar = aPermiteUsar;
    }

    /**
     * Access method for estadosDeAreas.
     *
     * @return the current value of estadosDeAreas
     */
    public Set<EstadosDeAreas> getEstadosDeAreas() {
        return estadosDeAreas;
    }

    /**
     * Setter method for estadosDeAreas.
     *
     * @param aEstadosDeAreas the new value for estadosDeAreas
     */
    public void setEstadosDeAreas(Set<EstadosDeAreas> aEstadosDeAreas) {
        estadosDeAreas = aEstadosDeAreas;
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
     * Compares the key for this instance with another Estados.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Estados and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Estados)) {
            return false;
        }
        Estados that = (Estados) other;
        if (this.getIdEstado() != that.getIdEstado()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Estados.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Estados)) return false;
        return this.equalKeys(other) && ((Estados)other).equalKeys(this);
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
        i = getIdEstado();
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
        StringBuffer sb = new StringBuffer("[Estados |");
        sb.append(" idEstado=").append(getIdEstado());
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
        ret.put("idEstado", Integer.valueOf(getIdEstado()));
        return ret;
    }

}
