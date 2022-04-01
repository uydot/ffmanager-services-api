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

@Entity(name="datos_institucion_deportiva")
public class DatosInstitucionDeportiva implements Serializable {

    /** Primary key. */
    protected static final String PK = "idDatosInstitucionDeportiva";

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
    @Column(name="id_datos_institucion_deportiva", unique=true, nullable=false, precision=10)
    private int idDatosInstitucionDeportiva;
    @Column(nullable=false, length=100)
    private String nombre;
    @Column(length=255)
    private String observaciones;
    @Column(nullable=false, length=200)
    private String direccion;
    @Column(name="telefono_contacto", length=45)
    private String telefonoContacto;
    @OneToMany(mappedBy="datosInstitucionDeportiva")
    private Set<Complejos> complejos;

    /** Default constructor. */
    public DatosInstitucionDeportiva() {
        super();
    }

    /**
     * Access method for idDatosInstitucionDeportiva.
     *
     * @return the current value of idDatosInstitucionDeportiva
     */
    public int getIdDatosInstitucionDeportiva() {
        return idDatosInstitucionDeportiva;
    }

    /**
     * Setter method for idDatosInstitucionDeportiva.
     *
     * @param aIdDatosInstitucionDeportiva the new value for idDatosInstitucionDeportiva
     */
    public void setIdDatosInstitucionDeportiva(int aIdDatosInstitucionDeportiva) {
        idDatosInstitucionDeportiva = aIdDatosInstitucionDeportiva;
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
     * Access method for complejos.
     *
     * @return the current value of complejos
     */
    public Set<Complejos> getComplejos() {
        return complejos;
    }

    /**
     * Setter method for complejos.
     *
     * @param aComplejos the new value for complejos
     */
    public void setComplejos(Set<Complejos> aComplejos) {
        complejos = aComplejos;
    }

    /**
     * Compares the key for this instance with another DatosInstitucionDeportiva.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class DatosInstitucionDeportiva and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof DatosInstitucionDeportiva)) {
            return false;
        }
        DatosInstitucionDeportiva that = (DatosInstitucionDeportiva) other;
        if (this.getIdDatosInstitucionDeportiva() != that.getIdDatosInstitucionDeportiva()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another DatosInstitucionDeportiva.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DatosInstitucionDeportiva)) return false;
        return this.equalKeys(other) && ((DatosInstitucionDeportiva)other).equalKeys(this);
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
        i = getIdDatosInstitucionDeportiva();
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
        StringBuffer sb = new StringBuffer("[DatosInstitucionDeportiva |");
        sb.append(" idDatosInstitucionDeportiva=").append(getIdDatosInstitucionDeportiva());
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
        ret.put("idDatosInstitucionDeportiva", Integer.valueOf(getIdDatosInstitucionDeportiva()));
        return ret;
    }

}
