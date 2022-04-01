// Generated with g9.

package com.services.api.ffmanager.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="areas", indexes={@Index(name="areas_NOMBRE_IX", columnList="NOMBRE", unique=true)})
public class Areas implements Serializable {

    /** Primary key. */
    protected static final String PK = "idArea";

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
    @Column(name="id_area", unique=true, nullable=false, precision=10)
    private int idArea;
    @Column(name="NOMBRE", unique=true, nullable=false, length=255)
    private String nombre;
    @Column(length=255)
    private String observaciones;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_complejo", nullable=false)
    private Complejos complejos;
    @OneToMany(mappedBy="areas")
    private Set<ReservaDeArea> reservaDeArea;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_tipo_area", nullable=false)
    private TiposAreas tiposAreas;
    @OneToMany(mappedBy="areas")
    private Set<EstadosDeAreas> estadosDeAreas;
    @OneToMany(mappedBy="areas")
    private Set<Sectores> sectores;

    /** Default constructor. */
    public Areas() {
        super();
    }

    /**
     * Access method for idArea.
     *
     * @return the current value of idArea
     */
    public int getIdArea() {
        return idArea;
    }

    /**
     * Setter method for idArea.
     *
     * @param aIdArea the new value for idArea
     */
    public void setIdArea(int aIdArea) {
        idArea = aIdArea;
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
     * Access method for complejos.
     *
     * @return the current value of complejos
     */
    public Complejos getComplejos() {
        return complejos;
    }

    /**
     * Setter method for complejos.
     *
     * @param aComplejos the new value for complejos
     */
    public void setComplejos(Complejos aComplejos) {
        complejos = aComplejos;
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
     * Access method for tiposAreas.
     *
     * @return the current value of tiposAreas
     */
    public TiposAreas getTiposAreas() {
        return tiposAreas;
    }

    /**
     * Setter method for tiposAreas.
     *
     * @param aTiposAreas the new value for tiposAreas
     */
    public void setTiposAreas(TiposAreas aTiposAreas) {
        tiposAreas = aTiposAreas;
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
     * Access method for sectores.
     *
     * @return the current value of sectores
     */
    public Set<Sectores> getSectores() {
        return sectores;
    }

    /**
     * Setter method for sectores.
     *
     * @param aSectores the new value for sectores
     */
    public void setSectores(Set<Sectores> aSectores) {
        sectores = aSectores;
    }

    /**
     * Compares the key for this instance with another Areas.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Areas and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Areas)) {
            return false;
        }
        Areas that = (Areas) other;
        if (this.getIdArea() != that.getIdArea()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Areas.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Areas)) return false;
        return this.equalKeys(other) && ((Areas)other).equalKeys(this);
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
        i = getIdArea();
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
        StringBuffer sb = new StringBuffer("[Areas |");
        sb.append(" idArea=").append(getIdArea());
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
        ret.put("idArea", Integer.valueOf(getIdArea()));
        return ret;
    }

}
