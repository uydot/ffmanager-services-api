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

@Entity(name="estados_de_sectores")
public class EstadosDeSectores implements Serializable {

   
    @Column(name="fecha_asignado", nullable=false)
    private LocalDateTime fechaAsignado;
    @Id
    @Column(name="id_estado_sector", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstadoSector;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_estado", nullable=false)
    private Estados estados;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_sector", nullable=false)
    private Sectores sectores;

    /** Default constructor. */
    public EstadosDeSectores() {
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
     * Access method for idEstadoSector.
     *
     * @return the current value of idEstadoSector
     */
    public int getIdEstadoSector() {
        return idEstadoSector;
    }

    /**
     * Setter method for idEstadoSector.
     *
     * @param aIdEstadoSector the new value for idEstadoSector
     */
    public void setIdEstadoSector(int aIdEstadoSector) {
        idEstadoSector = aIdEstadoSector;
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

    /**
     * Access method for sectores.
     *
     * @return the current value of sectores
     */
    public Sectores getSectores() {
        return sectores;
    }

    /**
     * Setter method for sectores.
     *
     * @param aSectores the new value for sectores
     */
    public void setSectores(Sectores aSectores) {
        sectores = aSectores;
    }

}
