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

@Entity(name="cargos")
public class Cargos implements Serializable {

    /** Primary key. */
    protected static final String PK = "idCargo";

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
    @Column(name="id_cargo", unique=true, nullable=false, precision=10)
    private int idCargo;
    @Column(nullable=false, length=45)
    private String nombre;
    @OneToMany(mappedBy="cargos")
    private Set<Usuarios> usuarios;

    /** Default constructor. */
    public Cargos() {
        super();
    }

    /**
     * Access method for idCargo.
     *
     * @return the current value of idCargo
     */
    public int getIdCargo() {
        return idCargo;
    }

    /**
     * Setter method for idCargo.
     *
     * @param aIdCargo the new value for idCargo
     */
    public void setIdCargo(int aIdCargo) {
        idCargo = aIdCargo;
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
     * Access method for usuarios.
     *
     * @return the current value of usuarios
     */
    public Set<Usuarios> getUsuarios() {
        return usuarios;
    }

    /**
     * Setter method for usuarios.
     *
     * @param aUsuarios the new value for usuarios
     */
    public void setUsuarios(Set<Usuarios> aUsuarios) {
        usuarios = aUsuarios;
    }

    /**
     * Compares the key for this instance with another Cargos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Cargos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Cargos)) {
            return false;
        }
        Cargos that = (Cargos) other;
        if (this.getIdCargo() != that.getIdCargo()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Cargos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Cargos)) return false;
        return this.equalKeys(other) && ((Cargos)other).equalKeys(this);
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
        i = getIdCargo();
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
        StringBuffer sb = new StringBuffer("[Cargos |");
        sb.append(" idCargo=").append(getIdCargo());
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
        ret.put("idCargo", Integer.valueOf(getIdCargo()));
        return ret;
    }

}
