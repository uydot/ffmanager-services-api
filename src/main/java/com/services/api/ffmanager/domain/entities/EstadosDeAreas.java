// Generated with g9.

package com.services.api.ffmanager.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="estados_de_areas")
public class EstadosDeAreas implements Serializable {

    @Column(name="fecha_asignado", nullable=false)
    private LocalDateTime fechaAsignado;
    @Id
    @Column(name="id_estado_area", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstadoArea;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_area", nullable=false)
    private Areas areas;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_estado", nullable=false)
    private Estados estados;

    /** Default constructor. */
    public EstadosDeAreas() {
        super();
    }

    /**
     * Access method for fechaAsignado.
     *
     * @return the current value of fechaAsignado
     */
    public LocalDateTime getFechaAsignado() {
        return fechaAsignado;
    }

    /**
     * Setter method for fechaAsignado.
     *
     * @param aFechaAsignado the new value for fechaAsignado
     */
    public void setFechaAsignado(LocalDateTime aFechaAsignado) {
        fechaAsignado = aFechaAsignado;
    }

    /**
     * Access method for idEstadoArea.
     *
     * @return the current value of idEstadoArea
     */
    public int getIdEstadoArea() {
        return idEstadoArea;
    }

    /**
     * Setter method for idEstadoArea.
     *
     * @param aIdEstadoArea the new value for idEstadoArea
     */
    public void setIdEstadoArea(int aIdEstadoArea) {
        idEstadoArea = aIdEstadoArea;
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
     * Access method for estados.
     *
     * @return the current value of estados
     */
    public Estados getEstados() {
        return estados;
    }

    /**
     * Setter method for estados.
     *
     * @param aEstados the new value for estados
     */
    public void setEstados(Estados aEstados) {
        estados = aEstados;
    }

}
