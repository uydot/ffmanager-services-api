// Generated with g9.

package com.services.api.ffmanager.domain.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="areas", indexes={@Index(name="areas_NOMBRE_IX", columnList="NOMBRE", unique=true)})
public class Areas implements Serializable {

  
    @Id
    @Column(name="id_area", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArea;
    @Column(name="NOMBRE", unique=true, nullable=false, length=255)
    private String nombre;
    @Column(length=255)
    private String observaciones;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_complejo", nullable=false)
    private Complejos complejos;
//    @OneToMany(mappedBy="areas")
//    private Set<ReservaDeArea> reservaDeArea;
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

//    /**
//     * Access method for reservaDeArea.
//     *
//     * @return the current value of reservaDeArea
//     */
//    public Set<ReservaDeArea> getReservaDeArea() {
//        return reservaDeArea;
//    }
//
//    /**
//     * Setter method for reservaDeArea.
//     *
//     * @param aReservaDeArea the new value for reservaDeArea
//     */
//    public void setReservaDeArea(Set<ReservaDeArea> aReservaDeArea) {
//        reservaDeArea = aReservaDeArea;
//    }

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


}
