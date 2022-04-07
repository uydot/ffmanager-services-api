// Generated with g9.

package com.services.api.ffmanager.domain.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="tipos_areas")
public class TiposAreas implements Serializable {

    @Id
    @Column(name="id_tipo_area", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoArea;
    @Column(length=255)
    private String nombre;
    @Column(length=255)
    private String descripcion;
    @Column(name="es_techada", nullable=false, length=1)
    private boolean esTechada;
    @Column(length=255)
    private String observaciones;
    @Column(name="es_compuesta", nullable=false, length=1)
    private boolean esCompuesta;
    @OneToMany(mappedBy="tiposAreas")
    private Set<Areas> areas;

    /** Default constructor. */
    public TiposAreas() {
        super();
    }

    /**
     * Access method for idTipoArea.
     *
     * @return the current value of idTipoArea
     */
    public int getIdTipoArea() {
        return idTipoArea;
    }

    /**
     * Setter method for idTipoArea.
     *
     * @param aIdTipoArea the new value for idTipoArea
     */
    public void setIdTipoArea(int aIdTipoArea) {
        idTipoArea = aIdTipoArea;
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
     * Access method for descripcion.
     *
     * @return the current value of descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter method for descripcion.
     *
     * @param aDescripcion the new value for descripcion
     */
    public void setDescripcion(String aDescripcion) {
        descripcion = aDescripcion;
    }

    /**
     * Access method for esTechada.
     *
     * @return true if and only if esTechada is currently true
     */
    public boolean isEsTechada() {
        return esTechada;
    }

    /**
     * Setter method for esTechada.
     *
     * @param aEsTechada the new value for esTechada
     */
    public void setEsTechada(boolean aEsTechada) {
        esTechada = aEsTechada;
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
     * Access method for esCompuesta.
     *
     * @return true if and only if esCompuesta is currently true
     */
    public boolean isEsCompuesta() {
        return esCompuesta;
    }

    /**
     * Setter method for esCompuesta.
     *
     * @param aEsCompuesta the new value for esCompuesta
     */
    public void setEsCompuesta(boolean aEsCompuesta) {
        esCompuesta = aEsCompuesta;
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

  
}
