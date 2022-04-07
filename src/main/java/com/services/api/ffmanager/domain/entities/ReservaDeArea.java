// Generated with g9.

package com.services.api.ffmanager.domain.entities;

import java.io.Serializable;
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

@Entity(name="reserva_de_area")
public class ReservaDeArea implements Serializable {


    @Id
    @Column(name="id_reserva_area", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservaArea;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_area", nullable=false)
    private Areas areas;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_reserva", nullable=false)
    private Reservas reservas;

    /** Default constructor. */
    public ReservaDeArea() {
        super();
    }

    /**
     * Access method for idReservaArea.
     *
     * @return the current value of idReservaArea
     */
    public int getIdReservaArea() {
        return idReservaArea;
    }

    /**
     * Setter method for idReservaArea.
     *
     * @param aIdReservaArea the new value for idReservaArea
     */
    public void setIdReservaArea(int aIdReservaArea) {
        idReservaArea = aIdReservaArea;
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
     * Access method for reservas.
     *
     * @return the current value of reservas
     */
    public Reservas getReservas() {
        return reservas;
    }

    /**
     * Setter method for reservas.
     *
     * @param aReservas the new value for reservas
     */
    public void setReservas(Reservas aReservas) {
        reservas = aReservas;
    }

}
