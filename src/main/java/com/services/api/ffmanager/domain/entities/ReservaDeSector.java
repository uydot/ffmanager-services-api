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

@Entity(name="reserva_de_sector")
public class ReservaDeSector implements Serializable {

  
    @Id
    @Column(name="id_reserva_sector", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservaSector;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_reserva", nullable=false)
    private Reservas reservas;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_sector", nullable=false)
    private Sectores sectores;

    /** Default constructor. */
    public ReservaDeSector() {
        super();
    }

    /**
     * Access method for idReservaSector.
     *
     * @return the current value of idReservaSector
     */
    public int getIdReservaSector() {
        return idReservaSector;
    }

    /**
     * Setter method for idReservaSector.
     *
     * @param aIdReservaSector the new value for idReservaSector
     */
    public void setIdReservaSector(int aIdReservaSector) {
        idReservaSector = aIdReservaSector;
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
