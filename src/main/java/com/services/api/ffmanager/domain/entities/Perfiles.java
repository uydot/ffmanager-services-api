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

@Entity(name="perfiles")
public class Perfiles implements Serializable {

    /** Primary key. */
    protected static final String PK = "idPerfil";

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
    @Column(name="id_perfil", unique=true, nullable=false, precision=10)
    private int idPerfil;
    @Column(nullable=false, length=45)
    private String nombre;
    @Column(name="es_admin", nullable=false, length=1)
    private boolean esAdmin;
    @OneToMany(mappedBy="perfiles")
    private Set<ItemsDePerfiles> itemsDePerfiles;
    @OneToMany(mappedBy="perfiles")
    private Set<Usuarios> usuarios;

    /** Default constructor. */
    public Perfiles() {
        super();
    }

    /**
     * Access method for idPerfil.
     *
     * @return the current value of idPerfil
     */
    public int getIdPerfil() {
        return idPerfil;
    }

    /**
     * Setter method for idPerfil.
     *
     * @param aIdPerfil the new value for idPerfil
     */
    public void setIdPerfil(int aIdPerfil) {
        idPerfil = aIdPerfil;
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
     * Access method for esAdmin.
     *
     * @return true if and only if esAdmin is currently true
     */
    public boolean isEsAdmin() {
        return esAdmin;
    }

    /**
     * Setter method for esAdmin.
     *
     * @param aEsAdmin the new value for esAdmin
     */
    public void setEsAdmin(boolean aEsAdmin) {
        esAdmin = aEsAdmin;
    }

    /**
     * Access method for itemsDePerfiles.
     *
     * @return the current value of itemsDePerfiles
     */
    public Set<ItemsDePerfiles> getItemsDePerfiles() {
        return itemsDePerfiles;
    }

    /**
     * Setter method for itemsDePerfiles.
     *
     * @param aItemsDePerfiles the new value for itemsDePerfiles
     */
    public void setItemsDePerfiles(Set<ItemsDePerfiles> aItemsDePerfiles) {
        itemsDePerfiles = aItemsDePerfiles;
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
     * Compares the key for this instance with another Perfiles.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Perfiles and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Perfiles)) {
            return false;
        }
        Perfiles that = (Perfiles) other;
        if (this.getIdPerfil() != that.getIdPerfil()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Perfiles.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Perfiles)) return false;
        return this.equalKeys(other) && ((Perfiles)other).equalKeys(this);
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
        i = getIdPerfil();
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
        StringBuffer sb = new StringBuffer("[Perfiles |");
        sb.append(" idPerfil=").append(getIdPerfil());
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
        ret.put("idPerfil", Integer.valueOf(getIdPerfil()));
        return ret;
    }

}
