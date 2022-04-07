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

@Entity(name="actividades_de_reserva")
public class ActividadesDeReserva implements Serializable {

   
    @Id
    @Column(name="id_actividad_reserva", unique=true, nullable=false, precision=10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActividadReserva;
    @Column(precision=10)
    private int duracion;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_actividad", nullable=false)
    private Actividades actividades;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_id_reserva", nullable=false)
    private Reservas reservas;

    /** Default constructor. */
    public ActividadesDeReserva() {
        super();
    }

    /**
     * Access method for idActividadReserva.
     *
     * @return the current value of idActividadReserva
     */
    public int getIdActividadReserva() {
        return idActividadReserva;
    }

    /**
     * Setter method for idActividadReserva.
     *
     * @param aIdActividadReserva the new value for idActividadReserva
     */
    public void setIdActividadReserva(int aIdActividadReserva) {
        idActividadReserva = aIdActividadReserva;
    }

    /**
     * Access method for duracion.
     *
     * @return the current value of duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Setter method for duracion.
     *
     * @param aDuracion the new value for duracion
     */
    public void setDuracion(int aDuracion) {
        duracion = aDuracion;
    }

    /**
     * Access method for actividades.
     *
     * @return the current value of actividades
     */
    public Actividades getActividades() {
        return actividades;
    }

    /**
     * Setter method for actividades.
     *
     * @param aActividades the new value for actividades
     */
    public void setActividades(Actividades aActividades) {
        actividades = aActividades;
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
