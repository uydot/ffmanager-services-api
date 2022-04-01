// Generated with g9.

package com.services.api.ffmanager.domain.entities;

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

@Entity(name="complejos")
public class Complejos implements Serializable {

    /** Primary key. */
    protected static final String PK = "idComplejo";

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
    @Column(name="id_complejo", unique=true, nullable=false, precision=10)
    private int idComplejo;
    @Column(nullable=false, length=100)
    private String nombre;
    @Column(nullable=false, length=200)
    private String direccion;
    @Column(name="telefono_contacto", nullable=false, length=45)
    private String telefonoContacto;
    @OneToMany(mappedBy="complejos")
    private Set<Areas> areas;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_institucion_deportiva", nullable=false)
    private DatosInstitucionDeportiva datosInstitucionDeportiva;

    /** Default constructor. */
    public Complejos() {
        super();
    }

    /**
     * Access method for idComplejo.
     *
     * @return the current value of idComplejo
     */
    public int getIdComplejo() {
        return idComplejo;
    }

    /**
     * Setter method for idComplejo.
     *
     * @param aIdComplejo the new value for idComplejo
     */
    public void setIdComplejo(int aIdComplejo) {
        idComplejo = aIdComplejo;
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
     * Access method for direccion.
     *
     * @return the current value of direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Setter method for direccion.
     *
     * @param aDireccion the new value for direccion
     */
    public void setDireccion(String aDireccion) {
        direccion = aDireccion;
    }

    /**
     * Access method for telefonoContacto.
     *
     * @return the current value of telefonoContacto
     */
    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    /**
     * Setter method for telefonoContacto.
     *
     * @param aTelefonoContacto the new value for telefonoContacto
     */
    public void setTelefonoContacto(String aTelefonoContacto) {
        telefonoContacto = aTelefonoContacto;
    }

    /**
     * Access method for areas.
     *
     * @return the current value of areas
     */
    public Set<Areas> getAreas() {
        return areas;
    }

    /**
     * Setter method for areas.
     *
     * @param aAreas the new value for areas
     */
    public void setAreas(Set<Areas> aAreas) {
        areas = aAreas;
    }

    /**
     * Access method for datosInstitucionDeportiva.
     *
     * @return the current value of datosInstitucionDeportiva
     */
    public DatosInstitucionDeportiva getDatosInstitucionDeportiva() {
        return datosInstitucionDeportiva;
    }

    /**
     * Setter method for datosInstitucionDeportiva.
     *
     * @param aDatosInstitucionDeportiva the new value for datosInstitucionDeportiva
     */
    public void setDatosInstitucionDeportiva(DatosInstitucionDeportiva aDatosInstitucionDeportiva) {
        datosInstitucionDeportiva = aDatosInstitucionDeportiva;
    }

    /**
     * Compares the key for this instance with another Complejos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Complejos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Complejos)) {
            return false;
        }
        Complejos that = (Complejos) other;
        if (this.getIdComplejo() != that.getIdComplejo()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Complejos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Complejos)) return false;
        return this.equalKeys(other) && ((Complejos)other).equalKeys(this);
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
        i = getIdComplejo();
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
        StringBuffer sb = new StringBuffer("[Complejos |");
        sb.append(" idComplejo=").append(getIdComplejo());
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
        ret.put("idComplejo", Integer.valueOf(getIdComplejo()));
        return ret;
    }

}
